package com.devsuperior.hreurekaserver.controller

import com.devsuperior.hreurekaserver.model.Worker
import com.devsuperior.hreurekaserver.service.WorkerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.ws.rs.core.Response

@RefreshScope
@RestController
@RequestMapping("/worker")
class WorkerController(
        private val workerService: WorkerService,
        private val env: Environment) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Value("\${test.config}")
    lateinit var testConfig: String

    @GetMapping
    fun listAllWorkers(): ResponseEntity<List<Worker>> = ResponseEntity.ok(workerService.listAllWorkers());

    @GetMapping("/{id}")
    fun getWorker(@PathVariable("id") id: Long): ResponseEntity<Worker> {
        logger.info("PORT = " + env.getProperty("local.server.port"))
        return ResponseEntity.ok(workerService.findWorker(id))
    };

    @GetMapping("/configs")
    fun getConfigs(): ResponseEntity<Worker> {
        logger.info("CONFIG = $testConfig")
        return ResponseEntity.noContent().build()
    }

}