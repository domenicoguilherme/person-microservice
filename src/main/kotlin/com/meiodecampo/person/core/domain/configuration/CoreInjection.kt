package com.meiodecampo.person.core.domain.configuration

import com.meiodecampo.person.core.ports.out.*
import com.meiodecampo.person.core.usecases.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoreInjection {

    @Bean
    fun findUsers(findUsersOutputPort: FindUsersOutputPort) = FindUsersUseCase(findUsersOutputPort)

    @Bean
    fun findUserById(findUserByIdOutputPort: FindUserByIdOutputPort) = FindUserByIdUseCase(findUserByIdOutputPort)

    @Bean
    fun findUserByDocument(findUserByDocumentOutputPort: FindUserByDocumentOutputPort) = FindUserByDocumentUseCase(findUserByDocumentOutputPort)

    @Bean
    fun deleteUser(deleteUserOutputPort: DeleteUserOutputPort) = DeleteUserUseCase(deleteUserOutputPort)

    @Bean
    fun updateUser(updateUserOutputPort: UpdateUserOutputPort) = UpdateUserUseCase(updateUserOutputPort)

    @Bean
    fun registerUser(saveUserOutputPort: RegisterUserOutputPort) = RegisterUserUseCase(saveUserOutputPort)
}