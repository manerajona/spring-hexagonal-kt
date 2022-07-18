package com.github.manerajona.blog.core.usecase

import com.github.manerajona.blog.core.Article
import com.github.manerajona.blog.core.ArticleId
import com.github.manerajona.blog.core.ArticleRepository
import com.github.manerajona.blog.core.ArticleService
import org.springframework.stereotype.Service

typealias BusinessRuleException = RuntimeException

@Service
class ArticleServiceImpl(private val repo: ArticleRepository) : ArticleService {

    override fun getAll() = repo.findAllByOrderByAddedAtDesc()

    @Throws(BusinessRuleException::class)
    override fun getById(id: Long) =
        repo.findById(id) ?: throw BusinessRuleException("This article does not exist")

    @Throws(BusinessRuleException::class)
    override fun postArticle(article: Article): ArticleId {

        val anyWithSameTitle = getAll().asSequence()
            .filter { it.title == article.title }
            .any()

        if (anyWithSameTitle) {
            throw BusinessRuleException("Two articles cannot have the same title")
        }
        return repo.create(article)
    }
}
