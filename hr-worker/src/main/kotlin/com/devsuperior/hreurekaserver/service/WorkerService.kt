package com.devsuperior.hreurekaserver.service

import com.devsuperior.hreurekaserver.model.Worker
import com.devsuperior.hreurekaserver.repository.WorkerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class WorkerService(private val workerRepository: WorkerRepository) {

    fun listAllWorkers(): List<Worker> = this.workerRepository.findAll()

    fun findWorker(id: Long): Worker {
        var worker: Optional<Worker> = this.workerRepository.findById(id)
        return worker.get()
    }

}