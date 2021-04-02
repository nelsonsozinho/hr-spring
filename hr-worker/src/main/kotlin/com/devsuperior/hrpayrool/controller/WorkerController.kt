package com.devsuperior.hrpayrool.controller

import com.devsuperior.hrpayrool.model.Worker
import com.devsuperior.hrpayrool.service.WorkerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/worker")
class WorkerController(
        private val workerService: WorkerService,
        private val env: Environment) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)


    @GetMapping
    fun listAllWorkers(): ResponseEntity<List<Worker>> = ResponseEntity.ok(workerService.listAllWorkers());

    @GetMapping("/{id}")
    fun getWorker(@PathVariable("id") id: Long): ResponseEntity<Worker> {
        logger.info("PORT = " + env.getProperty("local.server.port"))
        return ResponseEntity.ok(workerService.findWorker(id))
    };

}