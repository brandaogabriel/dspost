package com.devgabriel.dspost.models.dtos

import com.devgabriel.dspost.models.embedded.Author
import com.devgabriel.dspost.models.embedded.Comment
import com.devgabriel.dspost.models.entities.Post
import java.time.LocalDateTime

data class PostResponse(
    val id: String,
    val title: String,
    val body: String,
    val author: Author,
    val createdAt: LocalDateTime
) {

    private val commentsResponse = mutableListOf<Comment>()

    constructor(entity: Post) : this(
        id = entity.id!!,
        title = entity.title,
        body = entity.body,
        author = entity.author,
        createdAt = entity.createdAt
    ) {
        commentsResponse.addAll(entity.comments)
    }
}
