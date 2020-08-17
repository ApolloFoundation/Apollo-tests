import com.apollocurrency.aplwallet.apl.core.entity.blockchain.Transaction
import com.apollocurrency.aplwallet.apl.core.entity.state.account.Account
import com.apollocurrency.aplwallet.apl.core.rest.TransactionCreator
import com.apollocurrency.aplwallet.apl.core.service.state.account.AccountService
import com.apollocurrency.aplwallet.apl.core.transaction.messages.{Appendix, Attachment, EncryptToSelfMessageAppendix, PhasingAppendix}
import com.apollocurrency.aplwallet.apl.crypto.{Convert, Crypto}

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scalaj.http._
import com.fasterxml.jackson.databind.ObjectMapper

import scala.util.Random


class PerformanceSendMoney extends Simulation {


	val mapper = new ObjectMapper
	val env: String = System.getProperty("test.env")
	val users = System.getProperty("users").toDouble
	val duration = System.getProperty("duration").toDouble
	val childAccounts = System.getProperty("childAccounts")
	val ONE_APL = 100000000


	val httpProtocol = http.baseUrl(env)



	before {
		println("Start forging!")
		println(getTransactionBytes)
  	try {
					val response = Http(env+"/apl")
						.postForm
						.param("requestType","startForging")
						.param("secretPhrase","0").asString
				    	println(response.body)

					} catch { case e: Exception =>
						println(e.getMessage)
					}

	}


	val scn = scenario("Broadcast Transaction")
		.exec(http("Broadcast Transaction")
			.post(session => "/apl?" +
				"requestType=broadcastTransaction&" +
				"transactionBytes="+getTransactionBytes)
			.check(jsonPath("$.errorDescription").notExists.saveAs("errorDescription"))
		)

	val inject =	constantUsersPerSec(users) during (duration minutes)

	setUp(scn.inject(inject)).protocols(httpProtocol)

	def getTransactionBytes() : Array[Byte] = {
		val psecret = "1"

     val sender = "APL-632K-TWX3-2ALQ-973CU"
	   val csecret = "1"
	   val recipient = "APL-632K-TWX3-2ALQ-973CU"
		 val amount = "10"

		val senderAccountId = Convert.parseAccountId(sender)
		val recipientAccountId = Convert.parseAccountId(recipient)
		return new Array[Byte](1)
	}
}

}








