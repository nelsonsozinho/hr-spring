package com.devsuperior.hreurekaserver.service

import com.devsuperior.hreurekaserver.feignclient.WorkerFeignClient
import com.devsuperior.hreurekaserver.model.Payment
import com.devsuperior.hreurekaserver.model.Worker
import org.springframework.stereotype.Service

@Service
class PaymentService(private val workerFeignClient: WorkerFeignClient) {

    fun getPayment(workerId: Long, days: Int): Payment {
        val worker: Worker? = workerFeignClient.getWorker(workerId).body
        return Payment(worker!!.name, worker!!.dailyIncome, days)
    }

}