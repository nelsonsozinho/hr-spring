package com.devsuperior.hrpayrool.feignclient

import com.devsuperior.hrpayrool.model.Worker
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Component
@FeignClient(name = "hr-worker", url="localhost:8001", path="/worker")
interface WorkerFeignClient {

    @GetMapping("/{id}")
    fun getWorker(@PathVariable("id") id: Long): ResponseEntity<Worker>

}