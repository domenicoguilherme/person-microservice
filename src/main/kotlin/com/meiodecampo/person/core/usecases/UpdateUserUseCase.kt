package com.meiodecampo.person.core.usecases

import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.core.ports.`in`.UpdateUserInputPort
import com.meiodecampo.person.core.ports.out.UpdateUserOutputPort
import java.util.*

class UpdateUserUseCase(private val updateUserOutputPort: UpdateUserOutputPort): UpdateUserInputPort {
    override fun handle(id: UUID, user: User) = updateUserOutputPort.update(id, user)
}