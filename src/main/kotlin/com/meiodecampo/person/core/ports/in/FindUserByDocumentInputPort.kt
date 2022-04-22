package com.meiodecampo.person.core.ports.`in`

import com.meiodecampo.person.core.domain.models.User
import reactor.core.publisher.Mono

interface FindUserByDocumentInputPort {
    fun handle(document: String) : Mono<User>
}