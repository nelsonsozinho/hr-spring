package com.devsuperior.hreurekaserver.hreurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class HreurekaserverApplication

fun main(args: Array<String>) {
	runApplication<HreurekaserverApplication>(*args)
}
