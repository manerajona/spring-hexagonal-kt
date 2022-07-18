package com.github.manerajona.blog.ports.input.rs

import com.github.manerajona.blog.core.Article
import com.github.manerajona.blog.core.ArticleService
import com.github.manerajona.blog.core.usecase.BusinessRuleException
import org.springframework.http.HttpStatus.CONFLICT
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/articles")
class ArticleController(private val service: ArticleService) {

    @GetMapping
    fun findAll() = service.getAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long) = try {
        service.getById(id)
    } catch (ex: BusinessRuleException) {
        throw ResponseStatusException(NOT_FOUND, ex.message)
    }

    @PostMapping
    fun create(@RequestBody article: Article): ResponseEntity<Void> {

        val id = try {
            service.postArticle(article)
        } catch (ex: BusinessRuleException) {
            throw ResponseStatusException(CONFLICT, ex.message)
        }

        val location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(id)
            .toUri()

        return ResponseEntity.created(location).build()
    }
}
