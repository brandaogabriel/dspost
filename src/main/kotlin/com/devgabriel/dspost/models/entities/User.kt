package com.devgabriel.dspost.models.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class User(
    val name: String,
    val email: String
) {

    @Id
    var id: String? = null

    /**
     * @DBRef indica que essa lista de post é uma referencia a Posts que estão em outra collection
     */
    @DBRef(lazy = true)
    var posts = mutableListOf<Post>()
}