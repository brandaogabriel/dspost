package com.devgabriel.dspost.configuration

import com.devgabriel.dspost.models.embedded.Author
import com.devgabriel.dspost.models.embedded.Comment
import com.devgabriel.dspost.models.entities.Post
import com.devgabriel.dspost.models.entities.User
import com.devgabriel.dspost.repositories.PostRepository
import com.devgabriel.dspost.repositories.UserRepository
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import java.time.Instant
import javax.annotation.PostConstruct

@Configuration
@Profile("test")
class TestConfig(
    val userRepository: UserRepository,
    val postRepository: PostRepository,
) {

    @PostConstruct
    fun init(): Unit {
        userRepository.deleteAll()
        postRepository.deleteAll()

        val bob = User(id = null, name = "Bob Grey", email = "bob@email.com")
        val maria = User(id = null, name = "Maria Brown", email = "maria@email.com")
        val alex = User(id = null, name = "Alex Green", email = "alex@email.com")

        userRepository.saveAll(mutableListOf(bob, maria, alex))

        val post1 = Post(id = null, title = "Partiu Viagem", body = "Vou viajar para São Paulo. Abraços!", author = Author(maria))
        val post2 = Post(id = null, title = "Bom dia", body = "Acordei feliz hoje!", author = Author(maria))

        val comment1 = Comment(text = "Boa viagem mano!", moment = Instant.parse("2021-02-13T14:30:01Z"), author = Author(alex))
        val comment2 = Comment(text = "Aproveite", moment = Instant.parse("2021-02-13T15:38:05Z"), author = Author(bob))
        val comment3 = Comment(text = "Tenha um ótimo dia!", moment = Instant.parse("2021-02-14T12:34:26Z"), author = Author(alex))

        post1.comments.addAll(mutableListOf(comment1, comment2))
        post2.comments.addAll(mutableListOf(comment3))

        postRepository.saveAll(mutableListOf(post1, post2))

        maria.posts.addAll(mutableListOf(post1, post2))
        userRepository.save(maria)
    }

}