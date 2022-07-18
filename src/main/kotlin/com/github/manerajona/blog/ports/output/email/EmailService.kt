package com.github.manerajona.blog.ports.output.email

interface EmailService {
    fun sendText(from: String, to: String, subject: String, body: String)
    fun sendHTML(from: String, to: String, subject: String, body: String)
}
