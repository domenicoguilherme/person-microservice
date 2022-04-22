package com.meiodecampo.person.core.ports.`in`

import com.meiodecampo.person.core.domain.models.User
import reactor.core.publisher.Mono

interface RegisterUserInputPort {
    fun handle(user: User): Mono<User>
}