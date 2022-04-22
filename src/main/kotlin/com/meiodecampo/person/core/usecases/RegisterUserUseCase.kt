package com.meiodecampo.person.core.usecases

import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.core.ports.`in`.RegisterUserInputPort
import com.meiodecampo.person.core.ports.out.RegisterUserOutputPort

class RegisterUserUseCase(private val saveUserOutputPort: RegisterUserOutputPort): RegisterUserInputPort {
    override fun handle(user: User) = saveUserOutputPort.save(user)
}