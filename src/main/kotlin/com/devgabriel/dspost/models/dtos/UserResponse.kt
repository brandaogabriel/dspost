package com.devgabriel.dspost.models.dtos

import com.devgabriel.dspost.models.entities.User

data class UserResponse(
    val id: String,
    val name: String,
    val email: String
) {

    constructor(entity: User) : this(id = entity.id!!, name = entity.name, email = entity.email)
}
