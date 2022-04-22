package com.meiodecampo.person.core.ports.out

import reactor.core.publisher.Mono
import java.util.UUID

interface DeleteUserOutputPort {
    fun delete(id: UUID): Mono<Void>
}