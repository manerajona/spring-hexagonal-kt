package com.github.manerajona.blog.core

interface ArticleService {
    fun getAll(): List<Article>
    fun getById(id: ArticleId): Article
    fun postArticle(article: Article): ArticleId
}
