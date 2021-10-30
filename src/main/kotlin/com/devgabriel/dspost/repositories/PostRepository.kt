package com.devgabriel.dspost.repositories

import com.devgabriel.dspost.models.entities.Post
import org.springframework.data.mongodb.repository.MongoRepository

interface PostRepository : MongoRepository<Post, String> {
    fun findByTitle(title: String): List<Post>
}