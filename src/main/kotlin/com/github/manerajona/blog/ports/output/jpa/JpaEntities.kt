package com.github.manerajona.blog.ports.output.jpa

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class ArticleJpa(
    @Id @GeneratedValue val id: Long? = null,
    var title: String = "",
    var headline: String = "",
    var content: String = "",
    val addedAt: LocalDateTime = LocalDateTime.now(),
    val active: Boolean = true
)
