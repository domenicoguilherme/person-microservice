package com.meiodecampo.person.core.ports.`in`

import com.meiodecampo.person.core.domain.models.User
import reactor.core.publisher.Mono
import java.util.*

interface FindUserByIdInputPort {
    fun handle(id: UUID) : Mono<User>
}