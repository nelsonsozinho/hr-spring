package com.devsuperior.hroauth.services

import com.devsuperior.hroauth.entities.User
import com.devsuperior.hroauth.feignclients.UserFeignClient
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(private val userFeignClient: UserFeignClient): UserDetailsService {

    fun findByEmail(email: String): User {
        return userFeignClient.fundByEmail(email).body ?: throw IllegalArgumentException("Email $email not found")
    }

    override fun loadUserByUsername(username: String): UserDetails {
        return userFeignClient.fundByEmail(username).body ?: throw UsernameNotFoundException("Email $username not found")
    }

}