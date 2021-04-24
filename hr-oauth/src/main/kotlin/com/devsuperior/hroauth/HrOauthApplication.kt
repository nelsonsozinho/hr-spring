package com.devsuperior.hroauth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
//@EnableGlobalMethodSecurity(prePostEnabled = true)
class HrOauthApplication

fun main(args: Array<String>) {
	runApplication<HrOauthApplication>(*args)
}
