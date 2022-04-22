package com.meiodecampo.person.core.ports.`in`

import com.meiodecampo.person.core.domain.models.User
import reactor.core.publisher.Mono
import java.util.UUID

interface UpdateUserInputPort {
    fun handle(id: UUID, user: User): Mono<User>
}