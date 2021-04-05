package com.devsuperior.hreurekaserver.controller

import com.devsuperior.hreurekaserver.model.Payment
import com.devsuperior.hreurekaserver.service.PaymentService
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentController(private val service: PaymentService) {

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    fun getPayment(
            @PathVariable("workerId") workerId: Long,
            @PathVariable("days") days: Int): ResponseEntity<Payment> {
        return ResponseEntity.ok(service.getPayment(workerId, days))
    }

    fun getPaymentAlternative(workerId: Long, days: Int): ResponseEntity<Payment> {
        var payment = Payment("Bran", 400.0, days)
        return ResponseEntity.ok(payment)
    }

}