package com.meiodecampo.person.core.ports.out

import com.meiodecampo.person.core.domain.models.User
import reactor.core.publisher.Flux

interface FindUsersOutputPort {
    fun get() : Flux<User>
}