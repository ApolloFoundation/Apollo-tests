import java.util.UUID.randomUUID

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scalaj.http._

import scala.collection.JavaConverters._
import scala.concurrent.duration._
import scala.util.Random


class PerformanceSimulation extends Simulation {

	val env: String = System.getProperty("test.env")
	val users = System.getProperty("users").toDouble
	val duration = System.getProperty("duration").toDouble

	var peers = ConfigFactory.load("application.conf").getStringList(env).asScala.toList
	val random = new Random
	val httpProtocol = http.baseUrls(peers)


	before {

		println("Stop/Start forging!")
		for (peer <- peers) {
			try {
			println(peer)
			val response = Http(peer+"/apl")
				.postForm
				.param("requestType","stopForging")
  			.param("adminPassword","1").asString
		   	 println(response.body)
			} catch { case e: Exception =>
				println(e.getMessage)
			}
		 }

		for( i <- 1 to 200) {
				try {
					val peer = peers(
						random.nextInt(peers.length)
					)
					println(peer)
					val response = Http(peer+"/apl")
						.postForm
						.param("requestType","startForging")
						.param("secretPhrase",i.toString).asString
					println(response.body)
					} catch { case e: Exception =>
						println(e.getMessage)
					}
				}
	}


	val scn = scenario("Send Money")
		.exec(http("Get Account Id")
		.post("/apl?requestType=getAccountId&secretPhrase="+random.nextInt(200).toString)
			.check(status.is(200))
			.check(jsonPath("$.accountRS").find.saveAs("accountRS")))
		.pause(1)
		.exec(session => {
			val transaction = session("accountRS").asOption[String]
			session
		})
		.exec(http("Send Money")
		.post("/apl?" +
			"requestType=sendMoney&" +
			"feeATM=3000000000&" +
			"deadline=1440&" +
			"amountATM="+random.nextInt(2000).toString+"00000000&" +
			"recipient=${accountRS}&secretPhrase="+random.nextInt(200).toString))
		.exec { session =>
			println(session)
			session
		}

	val scn_1 = scenario("Shuffling")
		.exec(http("Shuffling Create")
			.post("/apl?" +
				"requestType=shufflingCreate&" +
				"amount=100000000000&" +
				"registrationPeriod=4000&" +
				"holdingType=0&" +
				"participantCount=3&" +
				"secretPhrase="+random.nextInt(50).toString+"&" +
				"feeATM=3000000000&deadline=1440")
			.check(status.is(200))
			.check(jsonPath("$.fullHash").find.saveAs("fullHash")))
		.exec(session => {
			val fullHash = session("fullHash").asOption[String]
			session
		})
	    .pause(10 seconds)
      .repeat(3) {
        val feeder = Iterator.continually(Map("id" -> randomUUID().toString,"pass" -> random.nextInt(200).toString))
        feed(feeder)
          .exec(http("Shuffling Join")
            .post("/apl?requestType=startShuffler&" +
              "shufflingFullHash=${fullHash}&" +
              "recipientSecretPhrase=${id}&" +
              "secretPhrase=${pass}&" +
              "createNoneTransactionMethod=true&" +
              "feeATM=3000000000" +
              "&deadline=1440")
            .check(status.is(200))
            .check(bodyString.saveAs("Response")))
        .exec { session =>
            println(session("Response").asOption[String])
            session
          }
      }

  var pass = random.nextInt(200).toString
  println(pass)
	val scn_2 = scenario("Alias")
			.exec(http("Set Alias")
				.post("/apl?" +
          "requestType=setAlias&" +
					"aliasURI=https://biblos.firstbridge.work/job/PerformanceTests-testnet-2&" +
					"aliasName=AL"+ System.currentTimeMillis().toString + "&" +
			  	"secretPhrase=" + pass + "&" +
					"feeATM=3000000000&" +
					"deadline=1440")
				.check(status.is(200))
        .check(bodyString.saveAs("BODY")))
			.exec(session => {
        val response = session("BODY").as[String]
          println(s"Response body: \n$response")
          session
				})


	val inject = 	constantUsersPerSec(users) during (duration minutes)
	val inject_ramp = 	rampUsers(25) during (duration minutes)
	setUp(
	  	scn.inject(inject),
	    scn_1.inject(inject_ramp),
      scn_2.inject(inject_ramp)
	).protocols(httpProtocol)
}


class CreateTransactionRequest{

	val deadlineValue = null
	val referencedTransactionFullHash = null
	val secretPhrase = null
	val publicKeyValue = null
	val passphrase = null

	val broadcast = false
	val validate = false
	val timestamp = 0
	val credential = null
	val version = null

	val encryptedMessageIsPrunable = false
	val messageIsPrunable = false
	val appendix = null

	val message = null
	val encryptToSelfMessage = null
	val phased = false
	val phasing = null

	val senderAccount = null
	val recipientId = 0L
	val recipientPublicKey = null

	val feeATM = 0L
	val amountATM = 0L
	val ecBlockHeight = 0
	val ecBlockId = 0L
	val publicKey = null
	val keySeed = null
	val attachment = null
}