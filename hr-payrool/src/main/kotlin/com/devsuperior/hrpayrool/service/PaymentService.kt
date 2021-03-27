package com.devsuperior.hrpayrool.service

import com.devsuperior.hrpayrool.model.Payment
import com.devsuperior.hrpayrool.model.Worker
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*

@Service
class PaymentService(private val restTemplate: RestTemplate) {

    @Value("\${hr-worker.host}")
    lateinit var workerHost: String

    fun getPayment(worker: Long, days: Int): Payment {
        val uriVariables: HashMap<String, String> = HashMap()
        uriVariables.put("id", worker.toString())

        val worker: Worker? = restTemplate.getForObject("$workerHost/worker/{id}", Worker::class.java, uriVariables)

        return Payment(worker!!.name, worker!!.dailyIncome, days)
    }

}