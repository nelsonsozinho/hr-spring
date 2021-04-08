package com.devsuperior.hruser.controller

import com.devsuperior.hruser.entities.User
import com.devsuperior.hruser.service.UserService
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RefreshScope
@RestController
@RequestMapping("/user")
class UserController(private var userService: UserService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<User> {
        return ResponseEntity.ok(userService.getUseById(id))
    }

    @GetMapping("/search")
    fun fundByEmail(@RequestParam("email") email: String): ResponseEntity<User> {
        return ResponseEntity.ok(userService.getUserByEmail(email))
    }

}