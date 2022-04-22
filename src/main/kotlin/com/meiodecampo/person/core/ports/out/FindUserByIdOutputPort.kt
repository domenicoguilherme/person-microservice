package com.meiodecampo.person.core.ports.out

import com.meiodecampo.person.core.domain.models.User
import reactor.core.publisher.Mono
import java.util.*

interface FindUserByIdOutputPort {
    fun getById(id: UUID) : Mono<User>
}