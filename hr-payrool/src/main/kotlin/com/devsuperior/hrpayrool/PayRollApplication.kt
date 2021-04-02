package com.devsuperior.hrpayrool

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.ribbon.RibbonClient
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
@RibbonClient("hr-worker")
class PayRollApplication

fun main(args: Array<String>) {
	runApplication<PayRollApplication>(*args)
}
