import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scalaj.http._
import com.typesafe.config.ConfigFactory
import scala.util.parsing.json._
import scala.util.Random
import com.google.gson.Gson
import scala.collection.JavaConverters._

class PerformanceSendMoney extends Simulation {

	val gson = new Gson
	val random = new Random
	val env: String = System.getProperty("test.env")
	val users = System.getProperty("users").toDouble
	val duration = System.getProperty("duration").toDouble
//	val childAccounts = ConfigFactory.load("application.conf").getString("childAccountsReq")
	var childPass = ConfigFactory.load("application.conf").getStringList("childPass").asScala.toList
	val parent = ConfigFactory.load("application.conf").getString("parent")
	val psecret = ConfigFactory.load("application.conf").getString("psecret")
	val ONE_APL = 100000000
	val httpProtocol = http.baseUrl(env)



	before {
		println("Start forging!")

  	try {
					val forgingResponse = Http(env+"/apl")
						.postForm
						.param("requestType","startForging")
						.param("secretPhrase","1").asString
				     println(forgingResponse.body)

		    	val setChildAccountsResponse = Http(env+"/rest/v2/account/test")
				    .postData(gson.toJson(new SetChildReq(parent,psecret,childPass.asJava))).header("content-type", "application/json").asString

		     	val trxByte = JSON.parseFull(setChildAccountsResponse.body).get.asInstanceOf[Map[String, Any]]("tx")


			    val broadcastResponse = Http(env+"/apl")
				     .postForm
				     .param("requestType","broadcastTransaction")
				     .param("transactionBytes",trxByte.toString).asString
			        println(broadcastResponse.body)

					} catch { case e: Exception =>
						println(e.getMessage)
					}

	}


	val scn = scenario("Send Money")
		.exec {session =>
			session.set("csecret",random.nextInt(99)+100000)
		}
		.exec(http("Get Recipient Account Id")
			.post("/apl?requestType=getAccountId&secretPhrase="+(random.nextInt(99)+100000).toString)
			.check(status.is(200))
			.check(jsonPath("$.accountRS").find.saveAs("accountRS")))
		.exec(http("Get Sender Account Id")
			.post("/apl?requestType=getAccountId&secretPhrase=${csecret}")
			.check(status.is(200))
			.check(jsonPath("$.accountRS").find.saveAs("SenderAccountRS")))
		.exec(http("Send Money v2")
			.post("/rest/v2/account/money")
			.body(StringBody(gson.toJson(new SendMoneyReq(parent,psecret,"${csecret}", "${SenderAccountRS}","${accountRS}", (random.nextInt(100) + 1)+"0000000"))
			)).asJson
			.check(jsonPath("$.errorDescription").notExists.saveAs("errorDescription"))
			.check(jsonPath("$.tx").find.saveAs("tx")))
	.exec (session =>{
		val tx = session("tx").as[String]
		//println(tx)
		session
		})
		.exec(http("Broadcast Transaction")
			.post("/apl?" +
				"requestType=broadcastTransaction&" +
				"transactionBytes=${tx}")
			.check(jsonPath("$.errorDescription").notExists.saveAs("errorDescription")))

	val inject =	constantUsersPerSec(users) during (duration minutes)

	setUp(scn.inject(inject)).protocols(httpProtocol)

}

class SendMoneyReq(var parent: String,var psecret: String,var csecret: String,var sender: String,var recipient: String,var amount: String) {
}
class SetChildReq(var parent: String,var psecret: String,val child_secret_list: java.util.List[String]) {
}
