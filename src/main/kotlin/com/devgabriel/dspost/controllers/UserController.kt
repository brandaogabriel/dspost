package com.devgabriel.dspost.controllers

import com.devgabriel.dspost.models.dtos.UserRequest
import com.devgabriel.dspost.models.dtos.UserResponse
import com.devgabriel.dspost.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

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

    @GetMapping("/{id}")
    fun userById(@PathVariable id: String): ResponseEntity<UserResponse> {
        val possibleUser = userRepository.findById(id)
        if(possibleUser.isEmpty) return ResponseEntity.notFound().build()

        val userResponse = UserResponse(possibleUser.get())
        return ResponseEntity.ok(userResponse)
    }

    @PostMapping
    fun createUser(@RequestBody @Valid request: UserRequest, builder: UriComponentsBuilder): ResponseEntity<Unit> {
        val user = request.paraUser()
        userRepository.save(user)

        val location = builder.path("/users/{id}").buildAndExpand(user.id).toUri()
        return ResponseEntity.created(location).build()
    }


}