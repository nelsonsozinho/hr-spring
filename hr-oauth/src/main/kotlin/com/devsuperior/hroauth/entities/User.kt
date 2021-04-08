package com.devsuperior.hroauth.entities

import java.util.*

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val roles: Set<Role> = HashSet<Role>()
)
