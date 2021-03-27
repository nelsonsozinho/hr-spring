package com.devsuperior.hrpayrool.model

import javax.persistence.*

@Entity
@Table(name = "tb_worker")
data class Worker(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        val name: String,

        val dailyIncome: Double
)