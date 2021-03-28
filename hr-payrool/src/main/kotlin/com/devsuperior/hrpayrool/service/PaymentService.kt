package com.devsuperior.hrpayrool.service

import com.devsuperior.hrpayrool.feignclient.WorkerFeignClient
import com.devsuperior.hrpayrool.model.Payment
import com.devsuperior.hrpayrool.model.Worker
import org.springframework.stereotype.Service

@Service
class PaymentService(private val workerFeignClient: WorkerFeignClient) {

    fun getPayment(workerId: Long, days: Int): Payment {
        val worker: Worker? = workerFeignClient.getWorker(workerId).body
        return Payment(worker!!.name, worker!!.dailyIncome, days)
    }

}