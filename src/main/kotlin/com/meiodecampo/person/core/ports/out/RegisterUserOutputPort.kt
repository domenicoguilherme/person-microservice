package com.meiodecampo.person.core.ports.out

import com.meiodecampo.person.core.domain.models.User
import reactor.core.publisher.Mono

interface RegisterUserOutputPort {
    fun save(user: User): Mono<User>
}