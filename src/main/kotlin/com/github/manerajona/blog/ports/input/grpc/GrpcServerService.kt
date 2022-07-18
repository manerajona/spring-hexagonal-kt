package com.github.manerajona.blog.ports.input.grpc

interface GrpcServerService {
    fun foo(req: Any, res: Any)
    fun bar(req: Any, res: Any)
}
