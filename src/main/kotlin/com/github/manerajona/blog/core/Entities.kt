package com.github.manerajona.blog.core

import java.time.LocalDateTime

typealias ArticleId = Long

data class Article(
    val id: ArticleId?,
    var title: String,
    var headline: String,
    var content: String,
    val addedAt: LocalDateTime?
)
