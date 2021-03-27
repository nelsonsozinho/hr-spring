package com.devsuperior.hrpayrool.controller

import com.devsuperior.hrpayrool.model.Worker
import com.devsuperior.hrpayrool.service.WorkerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/worker")
class WorkerController(private val workerService: WorkerService) {


    @GetMapping
    fun listAllWorkers(): ResponseEntity<List<Worker>> = ResponseEntity.ok(workerService.listAllWorkers());

    @GetMapping("/{id}")
    fun getWorker(@PathVariable("id") id: Long): ResponseEntity<Worker> = ResponseEntity.ok(workerService.findWorker(id));

}