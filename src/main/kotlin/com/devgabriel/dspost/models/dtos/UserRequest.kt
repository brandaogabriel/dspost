package com.devgabriel.dspost.models.dtos

import com.devgabriel.dspost.models.entities.User
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserRequest(
    @field:NotBlank
    val name: String,
    @field:NotBlank
    @field:Email
    val email: String
) {

    fun paraUser(): User {
        return User(name = name, email = email)
    }
}
