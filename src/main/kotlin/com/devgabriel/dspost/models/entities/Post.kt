package com.devgabriel.dspost.models.entities

import com.devgabriel.dspost.models.embedded.Author
import com.devgabriel.dspost.models.embedded.Comment
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "posts")
class Post(
    @Id
    var id: String?,
    val title: String,
    val body: String,
    val author: Author
) {

    var createdAt = LocalDateTime.now()
    var comments = mutableListOf<Comment>()
}