package com.devgabriel.dspost.models.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class User(
    @Id
    var id: String?,
    val name: String,
    val email: String
) {

    /**
     * @DBRef indica que essa lista de post é uma referencia a Posts que estão em outra collection
     */
    @DBRef(lazy = true)
    val posts = mutableListOf<Post>()
}