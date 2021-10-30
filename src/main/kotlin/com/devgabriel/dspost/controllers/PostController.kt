package com.devgabriel.dspost.controllers

import com.devgabriel.dspost.models.dtos.PostResponse
import com.devgabriel.dspost.repositories.PostRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    val postRepository: PostRepository
) {

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: String): ResponseEntity<PostResponse> {
        val possiblePost = postRepository.findById(id)

        val post = possiblePost.get()
        val response = PostResponse(post)
        return ResponseEntity.ok(response)
    }
}