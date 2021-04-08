package com.devsuperior.hroauth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
class HrOauthApplication

fun main(args: Array<String>) {
	runApplication<HrOauthApplication>(*args)
}
