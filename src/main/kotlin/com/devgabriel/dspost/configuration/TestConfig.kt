package com.devgabriel.dspost.configuration

import com.devgabriel.dspost.models.entities.User
import com.devgabriel.dspost.repositories.UserRepository
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.annotation.PostConstruct

@Configuration
@Profile("test")
class TestConfig(
    val userRepository: UserRepository
) {

    @PostConstruct
    fun init(): Unit {

        userRepository.deleteAll()

        val bob = User(id = null, name = "Bob Grey", email = "bob@email.com")
        val maria = User(id = null, name = "Maria Brown", email = "maria@email.com")
        val alex = User(id = null, name = "Alex Green", email = "alex@email.com")

        userRepository.saveAll(mutableListOf(bob, maria, alex))
    }

}