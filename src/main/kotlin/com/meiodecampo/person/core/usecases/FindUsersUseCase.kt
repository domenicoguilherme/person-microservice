package com.meiodecampo.person.core.usecases

import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.core.ports.`in`.FindUsersInputPort
import com.meiodecampo.person.core.ports.out.FindUsersOutputPort
import reactor.core.publisher.Flux

class FindUsersUseCase(private val findUsersOutputPort: FindUsersOutputPort): FindUsersInputPort {
    override fun handle(): Flux<User> {
        return findUsersOutputPort.get()
    }
}