package com.apollocurrency

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scalaj.http._
import com.typesafe.config.ConfigFactory

import scala.util.parsing.json._
import scala.util.Random
import com.google.gson.Gson
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.collection.JavaConverters._

class SendMoney_v2 extends Simulation {

	val gson = new Gson
	val random = new Random
	val env: String = System.getProperty("test.env")
	val users = System.getProperty("users").toDouble
	val duration = System.getProperty("duration").toDouble
	val forging = System.getProperty("forging").toBoolean
	val custompeer = System.getProperty("custompeer").toString
	var peers = ConfigFactory.load("application.conf").getStringList(env).asScala.toList
	var childPass = ConfigFactory.load("application.conf").getStringList("childPass").asScala.toList
	val parent = ConfigFactory.load("application.conf").getString("parent")
	val psecret = ConfigFactory.load("application.conf").getString("psecret")
	val ONE_APL = 100000000
	val httpProtocol = getPeers(custompeer)



	before {

  	try {
			if (forging) {
				println("Stop/Start forging!")
				for (peer <- peers) {
					try {
						println(peer)
						val response = Http(peer + "/apl")
							.postForm
							.param("requestType", "stopForging")
							.param("adminPassword", "1").asString
						println(response.body)

					} catch {
						case e: Exception =>
							println(e.getMessage)
					}
				}

				for (i <- 1 to 200) {
					try {
						val peer = peers(
							random.nextInt(peers.length)
						)
						println(peer)
						val response = Http(peer + "/apl")
							.postForm
							.param("requestType", "startForging")
							.param("secretPhrase", i.toString).asString
						println(response.body)
					} catch {
						case e: Exception =>
							println(e.getMessage)
					}
				}
			}
		    	val setChildAccountsResponse = Http(getPeer(custompeer)+"/rest/v2/account/test")
				    .postData(gson.toJson(new SetChildReq(parent,psecret,childPass.asJava))).header("content-type", "application/json").asString

		     	val trxByte = JSON.parseFull(setChildAccountsResponse.body).get.asInstanceOf[Map[String, Any]]("tx")


			    val broadcastResponse = Http(getPeer(custompeer)+"/apl")
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
             .set("amountATM",(random.nextInt(1000) + 1)+"00000000")
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
			.body(StringBody(gson.toJson(new SendMoneyReq(parent,psecret,"${csecret}", "${SenderAccountRS}","${accountRS}", "${amountATM}"))
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

	def getPeers(custompeer: String):HttpProtocolBuilder = {
		if (custompeer.equals("")){
			return http.baseUrls(peers)
		}else{
			return http.baseUrl(custompeer)
		}
	}

	def getPeer(custompeer: String):String = {
		if (custompeer.equals("")){
			return peers(0)
		}else{
			return custompeer
		}
	}
}

class SendMoneyReq(var parent: String,var psecret: String,var csecret: String,var sender: String,var recipient: String,var amount: String) {
}
class SetChildReq(var parent: String,var psecret: String,val child_secret_list: java.util.List[String]) {
}
