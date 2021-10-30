package com.devgabriel.dspost.controllers

import com.devgabriel.dspost.models.dtos.UserResponse
import com.devgabriel.dspost.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userRepository: UserRepository
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<UserResponse>> {
        val users = userRepository.findAll()
        val usersResponse = users.map { user -> UserResponse(user) }
        return ResponseEntity.ok(usersResponse)
    }
}