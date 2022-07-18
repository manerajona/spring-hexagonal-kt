package com.github.manerajona.blog.ports.output.jpa

import com.github.manerajona.blog.core.Article
import com.github.manerajona.blog.core.ArticleId
import com.github.manerajona.blog.core.ArticleRepository
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Primary
@Component
class ArticleDao(private val db: ArticleJpaRepository) : ArticleRepository {

    override fun findAllByOrderByAddedAtDesc(): List<Article> {
        return db.findAllByOrderByAddedAtDesc().asSequence()
            .map { articleJpaToArticle(it) }
            .toList()
    }

    override fun findById(id: Long): Article? {
        return db.findByIdAndActiveTrue(id)
            .map { articleJpaToArticle(it) }
            .orElse(null)
    }

    @Transactional
    override fun create(article: Article): ArticleId {
        val entity = articleToArticleJpa(article)
        return db.save(entity).id as ArticleId
    }
}

internal fun articleJpaToArticle(it: ArticleJpa) = Article(
    id = it.id,
    title = it.title,
    headline = it.headline,
    content = it.content,
    addedAt = it.addedAt
)

internal fun articleToArticleJpa(it: Article) = ArticleJpa(
    id = it.id,
    title = it.title,
    headline = it.headline,
    content = it.content
)
