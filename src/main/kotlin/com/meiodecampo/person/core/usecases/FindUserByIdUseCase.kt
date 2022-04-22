package com.meiodecampo.person.core.usecases

import com.meiodecampo.person.core.ports.`in`.FindUserByIdInputPort
import com.meiodecampo.person.core.ports.out.FindUserByIdOutputPort
import java.util.*

class FindUserByIdUseCase(private val findUserByIdOutputPort: FindUserByIdOutputPort): FindUserByIdInputPort {
    override fun handle(id: UUID) = findUserByIdOutputPort.getById(id)
}