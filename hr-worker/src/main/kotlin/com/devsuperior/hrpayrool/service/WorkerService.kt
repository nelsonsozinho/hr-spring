package com.devsuperior.hrpayrool.service

import com.devsuperior.hrpayrool.model.Worker
import com.devsuperior.hrpayrool.repository.WorkerRepository
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