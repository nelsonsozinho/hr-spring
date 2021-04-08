package com.devsuperior.hruser.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tb_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String,

    @Column(unique = true)
    val email: String,

    val password: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tb_user_role",
        joinColumns = [JoinColumn(name="user_id")],
        inverseJoinColumns = [JoinColumn(name="role_id")]
    )
    val roles: Set<Role> = HashSet<Role>()
)
