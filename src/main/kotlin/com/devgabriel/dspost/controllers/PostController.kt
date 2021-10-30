package com.devgabriel.dspost.controllers

import com.devgabriel.dspost.models.dtos.PostResponse
import com.devgabriel.dspost.repositories.PostRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/titlesearch")
    fun getPostsByTitle(@RequestParam(name = "text", required = true) text: String): ResponseEntity<List<PostResponse>> {
        val posts = postRepository.findByTitleContainingIgnoreCase(text)
        val response = posts.map { post -> PostResponse(post) }
        return ResponseEntity.ok(response)
    }
}