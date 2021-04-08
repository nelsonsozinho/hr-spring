package com.devsuperior.hroauth.services

import com.devsuperior.hroauth.entities.User
import com.devsuperior.hroauth.feignclients.UserFeignClient
import org.springframework.stereotype.Service

@Service
class UserService(private val userFeignClient: UserFeignClient) {

    fun findByEmail(email: String): User {
        return userFeignClient.fundByEmail(email).body ?: throw IllegalArgumentException("Email $email not found")
    }

}