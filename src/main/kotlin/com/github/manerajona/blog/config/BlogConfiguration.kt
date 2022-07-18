package com.github.manerajona.blog.config

import com.github.manerajona.blog.ports.output.jpa.ArticleJpa
import com.github.manerajona.blog.ports.output.jpa.ArticleJpaRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(articleRepository: ArticleJpaRepository) = ApplicationRunner {

        articleRepository.save(
            ArticleJpa(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
            )
        )

        articleRepository.save(
            ArticleJpa(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
            )
        )
    }
}
