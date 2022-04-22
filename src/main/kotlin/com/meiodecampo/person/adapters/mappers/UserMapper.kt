package com.meiodecampo.person.adapters.mappers

import com.meiodecampo.person.adapters.out.repository.entities.UserEntity
import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.adapters.`in`.api.models.request.UserRegisterRequest
import com.meiodecampo.person.adapters.`in`.api.models.request.UserUpdateRequest
import com.meiodecampo.person.adapters.`in`.api.models.response.UserResponse
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserMapper {
    fun toUserEntity(user: User) = UserEntity(
        id = user.id,
        firstName = user.firstName,
        document = user.document,
        lastName = user.lastName,
        nickname = user.nickname,
    )

    fun toUser(userEntity: UserEntity) = User(
        id = userEntity.id,
        firstName = userEntity.firstName,
        document = userEntity.document,
        lastName = userEntity.lastName,
        nickname = userEntity.nickname,
    )

    fun toUser(userRegisterRequest: UserRegisterRequest) = User(
        UUID.randomUUID(),
        firstName = userRegisterRequest.firstName,
        document = userRegisterRequest.document,
        lastName = userRegisterRequest.lastName,
        nickname = userRegisterRequest.nickname,
    )

    fun toUser(id: UUID, userUpdateRequest: UserUpdateRequest) = User(
        id,
        firstName = userUpdateRequest.firstName,
        document = userUpdateRequest.document,
        lastName = userUpdateRequest.lastName,
        nickname = userUpdateRequest.nickname
    )

    fun toUserResponse(user: User) = UserResponse(
        user.id,
        user.firstName,
        user.lastName,
        user.nickname,
        user.document
    )
}