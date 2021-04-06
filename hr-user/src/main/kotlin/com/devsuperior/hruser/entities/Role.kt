package com.devsuperior.hruser.entities

import javax.persistence.*

@Entity
@Table(name = "tb_role")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val roleName: String
)