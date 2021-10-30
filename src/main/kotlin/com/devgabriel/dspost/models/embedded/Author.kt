package com.devgabriel.dspost.models.embedded

import com.devgabriel.dspost.models.entities.User


class Author(
    val id: String?,
    val name: String,
) {

    //Secondary constructor
    constructor(entity: User) : this(id = entity.id, name = entity.name)
}