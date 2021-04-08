package com.devsuperior.hroauth.controller

import com.devsuperior.hroauth.entities.User
import com.devsuperior.hroauth.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping("/search")
    fun findByEmail(@RequestParam("email")email: String): ResponseEntity<User> {
        return try {
            val user: User = userService.findByEmail(email)
            ResponseEntity.ok(user)
        } catch(e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

}