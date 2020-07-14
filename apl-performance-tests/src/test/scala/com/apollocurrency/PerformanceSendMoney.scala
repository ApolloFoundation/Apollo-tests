package com.apollocurrency

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


class PerformanceSendMoney extends Simulation {

	val env: String = System.getProperty("test.env")
	val users = System.getProperty("users").toDouble
	val duration = System.getProperty("duration").toDouble

	val httpProtocol = http.baseUrl(env)



	before {
		println("Start forging!")
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


	val scn = scenario("Send Money")
		.exec(http("Send Money")
			.post(session => "/apl?" +
				"requestType=sendMoney&" +
				"feeATM=3000000000&" +
				"deadline=1440&" +
				"amountATM="+(Random.nextInt(200)+1).toString+"00000000&" +
				"recipient=APL-NZKH-MZRE-2CTT-98NPZ&secretPhrase="+Random.nextInt(200).toString)
			.check(jsonPath("$.errorDescription").notExists.saveAs("errorDescription"))
		)

	val inject =	constantUsersPerSec(users) during (duration minutes)


	setUp(scn.inject(inject)).protocols(httpProtocol)
}