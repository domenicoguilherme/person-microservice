package com.meiodecampo.person.core.ports.`in`

import com.meiodecampo.person.core.domain.models.User
import reactor.core.publisher.Flux

interface FindUsersInputPort {
    fun handle() : Flux<User>
}