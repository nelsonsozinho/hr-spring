package com.devsuperior.hreurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient


@SpringBootApplication
@EnableEurekaClient
class HrworkerApplication

fun main(args: Array<String>) {
	runApplication<HrworkerApplication>(*args)
}
