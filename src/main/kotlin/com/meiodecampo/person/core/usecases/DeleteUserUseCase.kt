package com.meiodecampo.person.core.usecases

import com.meiodecampo.person.core.ports.`in`.DeleteUserInputPort
import com.meiodecampo.person.core.ports.out.DeleteUserOutputPort
import reactor.core.publisher.Mono
import java.util.*

class DeleteUserUseCase(private val deleteUserOutputPort: DeleteUserOutputPort): DeleteUserInputPort {
    override fun handle(id: UUID): Mono<Void> {
        return deleteUserOutputPort.delete(id)
    }
}