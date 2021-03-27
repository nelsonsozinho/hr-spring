package com.devsuperior.hrpayrool.repository

import com.devsuperior.hrpayrool.model.Worker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkerRepository: JpaRepository<Worker, Long>