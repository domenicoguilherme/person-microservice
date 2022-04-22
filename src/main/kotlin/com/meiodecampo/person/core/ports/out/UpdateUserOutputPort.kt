package com.meiodecampo.person.core.ports.out

import com.meiodecampo.person.core.domain.models.User
import reactor.core.publisher.Mono
import java.util.UUID

interface UpdateUserOutputPort {
    fun update(id: UUID, user: User): Mono<User>
}