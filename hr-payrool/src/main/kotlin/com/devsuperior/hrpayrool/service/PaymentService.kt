package com.devsuperior.hrpayrool.service

import com.devsuperior.hrpayrool.model.Payment
import org.springframework.stereotype.Service

@Service
class PaymentService {

    fun getPayment(worker: Long, days: Int): Payment {
        return Payment("Bob", 200.0, days)
    }

}