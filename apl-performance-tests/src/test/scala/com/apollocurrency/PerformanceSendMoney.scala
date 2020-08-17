package com.apollocurrency

import java.nio.ByteBuffer

import com.apollocurrency.aplwallet.apl.core.entity.blockchain.Transaction
import com.apollocurrency.aplwallet.apl.core.entity.state.account.Account
import com.apollocurrency.aplwallet.apl.core.model.CreateTransactionRequest
import com.apollocurrency.aplwallet.apl.core.rest.TransactionCreator
import com.apollocurrency.aplwallet.apl.core.service.state.account.AccountService
import com.apollocurrency.aplwallet.apl.core.transaction.messages.{Appendix, Attachment, EncryptToSelfMessageAppendix, PhasingAppendix}
import com.apollocurrency.aplwallet.apl.crypto.{Convert, Crypto}

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scalaj.http._
import com.fasterxml.jackson.databind.ObjectMapper
import com.typesafe.config.ConfigFactory
import scala.util.parsing.json._
import scala.util.Random
import com.google.gson.Gson

class PerformanceSendMoney extends Simulation {

	val gson = new Gson
	val random = new Random
	val env: String = System.getProperty("test.env")
	val users = System.getProperty("users").toDouble
	val duration = System.getProperty("duration").toDouble
	val childAccounts = ConfigFactory.load("application.conf").getString("childAccountsReq")
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
				    .postData(childAccounts).header("content-type", "application/json").asString

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
		.exec(http("Get Recipient Account Id")
			.post(session =>"/apl?requestType=getAccountId&secretPhrase="+(random.nextInt(999)+100000).toString)
			.check(status.is(200))
			.check(jsonPath("$.accountRS").find.saveAs("accountRS")))
		.exec(http("Get Sender Account Id")
			.post("/apl?requestType=getAccountId&secretPhrase="+(random.nextInt(999)+100000).toString)
			.check(status.is(200))
			.check(jsonPath("$.accountRS").find.saveAs("SenderAccountRS")))
		.exec(http("Send Money v2")
			.post("/rest/v2/account/money")
			.body(StringBody(gson.toJson(new SendMoneyReq((random.nextInt(999) + 100000), "${SenderAccountRS}","${accountRS}", random.nextInt(800) + 1))
			)).asJson
			.check(jsonPath("$.tx").find.saveAs("tx"))
		  .check(bodyString.saveAs("BODY")))
	.exec (session =>{
		val response = session("BODY").as[String]
		val tx = session("tx").as[String]
		//println(tx)
		//println(s"Response body: $response")
		session
		})
		.exec(http("Broadcast Transaction")
			.post("/apl?" +
				"requestType=broadcastTransaction&" +
				"transactionBytes=${tx}")
			.check(bodyString.saveAs("BODY1"))
			.check(jsonPath("$.errorDescription").notExists.saveAs("errorDescription"))
		).exec (session =>{
		val response = session("BODY1").as[String]
		println(s"Response body: $response")
		session
	})

	val inject =	constantUsersPerSec(users) during (duration minutes)

	setUp(scn.inject(inject)).protocols(httpProtocol)

}

class SendMoneyReq(var csecret: Int,var sender: String,var recipient: String,var amount: Int) {
  val parent = "APL-X5JH-TJKJ-DVGC-5T2V8"
	val psecret = "1"
}










