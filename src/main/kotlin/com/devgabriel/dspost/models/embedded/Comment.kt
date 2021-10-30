package com.devgabriel.dspost.models.embedded

import java.time.Instant

class Comment(
    val text: String,
    val moment: Instant,
    val author: Author
) {
}