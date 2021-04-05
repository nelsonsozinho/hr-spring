package com.devsuperior.hrapigatewayzuul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
class HrApiGatewayZuulApplication

fun main(args: Array<String>) {
	runApplication<HrApiGatewayZuulApplication>(*args)
}
