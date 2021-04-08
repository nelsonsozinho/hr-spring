package com.devsuperior.hruser.service

import com.devsuperior.hruser.entities.User
import com.devsuperior.hruser.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUseById(id: Long): User = userRepository.getOne(id)

    fun getUserByEmail(email: String): User = userRepository.findByEmail(email)

}