package com.meiodecampo.person.adapters.`in`.api

import com.meiodecampo.person.adapters.`in`.api.exceptions.InternalServerErrorHttpResponse
import com.meiodecampo.person.adapters.`in`.api.exceptions.NotFoundHttpResponse
import com.meiodecampo.person.adapters.mappers.UserMapper
import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.adapters.`in`.api.models.request.UserRegisterRequest
import com.meiodecampo.person.adapters.`in`.api.models.request.UserUpdateRequest
import com.meiodecampo.person.adapters.`in`.api.models.response.UserResponse
import com.meiodecampo.person.core.ports.`in`.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toMono
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userMapper: UserMapper,
    private val findUsersInputPort: FindUsersInputPort,
    private val deleteUserInputPort: DeleteUserInputPort,
    private val updateUserInputPort: UpdateUserInputPort,
    private val registerUserInputPort: RegisterUserInputPort,
    private val findUserByIdInputPort: FindUserByIdInputPort,
    private val findUserByDocumentInputPort: FindUserByDocumentInputPort
) {
    @GetMapping
    fun getAll() = findUsersInputPort.handle()
        .map { userMapper.toUserResponse(it) }
        .collectList()
        .map { ResponseEntity.ok(it) }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID) = findUserByIdInputPort.handle(id)
        .map { userMapper.toUserResponse(it) }
        .map { ResponseEntity.ok(it) }
        .switchIfEmpty { NotFoundHttpResponse().toMono() }

    @GetMapping("/bydocument/{document}")
    fun getByDocument(@PathVariable document: String) = findUserByDocumentInputPort.handle(document)
        .map { userMapper.toUserResponse(it) }
        .map { ResponseEntity.ok(it) }
        .switchIfEmpty { NotFoundHttpResponse().toMono() }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) = deleteUserInputPort.handle(id)

    @PostMapping
    fun register(@RequestBody @Validated userRegisterRequest: UserRegisterRequest): Mono<ResponseEntity<UserResponse>> {
        val user = userMapper.toUser(userRegisterRequest)

        return findUserByDocumentInputPort.handle(user.document)
            .map { userMapper.toUserResponse(it) }
            .map { ResponseEntity.ok(it) }
            .switchIfEmpty { registerUser(user) }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody @Validated userUpdateRequest: UserUpdateRequest): Mono<ResponseEntity<UserResponse>> {
        val user = userMapper.toUser(id, userUpdateRequest)

        return updateUserInputPort.handle(id, user)
            .map { userMapper.toUserResponse(it) }
            .map { ResponseEntity.ok(it) }
            .switchIfEmpty { InternalServerErrorHttpResponse("Não foi possível atualizar o usuário").toMono() }
    }

    private fun registerUser(user: User) = registerUserInputPort.handle(user)
        .map { userMapper.toUserResponse(it) }
        .map { ResponseEntity.ok(it) }
        .switchIfEmpty { InternalServerErrorHttpResponse("Ocorreu um erro ao criar o usuário").toMono() }
}