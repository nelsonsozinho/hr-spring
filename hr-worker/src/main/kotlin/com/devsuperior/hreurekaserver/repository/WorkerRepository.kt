package com.devsuperior.hreurekaserver.repository

import com.devsuperior.hreurekaserver.model.Worker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkerRepository: JpaRepository<Worker, Long>