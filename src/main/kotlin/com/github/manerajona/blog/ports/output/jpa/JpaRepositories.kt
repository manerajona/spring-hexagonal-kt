package com.github.manerajona.blog.ports.output.jpa

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ArticleJpaRepository : JpaRepository<ArticleJpa, Long> {
    fun findAllByOrderByAddedAtDesc(): List<ArticleJpa>
    fun findByIdAndActiveTrue(id: Long): Optional<ArticleJpa>
}
