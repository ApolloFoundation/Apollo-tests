import com.typesafe.config.ConfigFactory

import collection.JavaConverters._
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import scala.util.Random
import scalaj.http._
import java.util.UUID.randomUUID
import java.util.concurrent.TimeUnit

import com.apollocurrency.{CreateTransactionRequest, SendMoneyReq}
import com.apollocurrency.aplwallet.apl.core.rest.TransactionCreator
import com.apollocurrency.aplwallet.apl.core.transaction.messages.Attachment
import com.apollocurrency.aplwallet.apl.crypto.Crypto
import com.fasterxml.jackson.databind.ObjectMapper


class PerformanceSendMoney extends Simulation {


	val mapper = new ObjectMapper
	val env: String = System.getProperty("test.env")
	val users = System.getProperty("users").toDouble
	val duration = System.getProperty("duration").toDouble
	val duration = System.getProperty("childAccounts")


	val httpProtocol = http.baseUrl(env)



	before {
		println("Start forging!")
  	try {
					val response = Http(env+"/apl")
						.postForm
						.param("requestType","startForging")
						.param("secretPhrase","0").asString
				  	println(response.body)
			//.body(StringBody(mapper.writeValueAsString(new SendMoneyReq))

					} catch { case e: Exception =>
						println(e.getMessage)
					}

	}


	val scn = scenario("Send Money")
		.exec(http("Send Money")
			.post(session => "/apl?" +
				"requestType=sendMoney&" +
				"feeATM=3000000000&" +
				"deadline=1440&" +
				"amountATM="+(Random.nextInt(200)+1).toString+"00000000&" +
				"recipient=APL-NZKH-MZRE-2CTT-98NPZ&secretPhrase="+Random.nextInt(1000).toString)
			.check(jsonPath("$.errorDescription").notExists.saveAs("errorDescription"))
		)

	val inject =	constantUsersPerSec(users) during (duration minutes)

	var txRequest =  new CreateTransactionRequest
	txRequest.version = 2
	txRequest.publicKey = Crypto.getPublicKey(csecret)
	txRequest.recipientId = recipientAccountId
	txRequest.deadlineValue = "1440"
	txRequest.amountATM = amount
	txRequest.feeATM = 0
	txRequest.attachment = Attachment.ORDINARY_PAYMENT
	txRequest.broadcast = false
	txRequest.validat = false
	txRequest.message = new MessageAppendix("Simple text message")
	txRequest.credential = new MultiSigCredential(2, Crypto.getKeySeed(csecret), Crypto.getKeySeed(psecret))
	TransactionCreator transactionCreator = new TransactionCreator
	val transaction = transactionCreator.createTransactionThrowingException(txRequest)

	setUp(scn.inject(inject)).protocols(httpProtocol)
}