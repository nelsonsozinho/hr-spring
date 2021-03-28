package com.devsuperior.hrpayrool.controller

import com.devsuperior.hrpayrool.model.Payment
import com.devsuperior.hrpayrool.service.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentController(private val service: PaymentService) {

    @GetMapping("/{workerId}/days/{days}")
    fun getPayment(
            @PathVariable("workerId") workerId: Long,
            @PathVariable("days") days: Int): ResponseEntity<Payment> {
        return ResponseEntity.ok(service.getPayment(workerId, days))
    }

}