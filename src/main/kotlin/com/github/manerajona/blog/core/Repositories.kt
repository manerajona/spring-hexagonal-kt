package com.github.manerajona.blog.core

interface ArticleRepository {
    fun findAllByOrderByAddedAtDesc(): List<Article>
    fun findById(id: ArticleId): Article?
    fun create(article: Article): ArticleId
}
