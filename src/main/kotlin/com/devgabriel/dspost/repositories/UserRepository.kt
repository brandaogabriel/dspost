package com.devgabriel.dspost.repositories

import com.devgabriel.dspost.models.entities.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String>