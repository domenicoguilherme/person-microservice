package com.meiodecampo.person.adapters.out.repository

import com.meiodecampo.person.adapters.mappers.UserMapper
import com.meiodecampo.person.adapters.out.repository.entities.UserEntity
import com.meiodecampo.person.adapters.out.repository.mongoRepository.UserMongoRepository
import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.core.ports.out.*
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toMono
import java.util.UUID

@Repository
class UserRepository(
    private val userMongoRepository: UserMongoRepository,
    private val userMapper: UserMapper
):
    FindUsersOutputPort,
    DeleteUserOutputPort,
    UpdateUserOutputPort,
    RegisterUserOutputPort,
    FindUserByIdOutputPort,
    FindUserByDocumentOutputPort
{
    override fun get() = userMongoRepository.findAll()
        .map { userMapper.toUser(it) }

    override fun getById(id: UUID) = userMongoRepository.findById(id)
        .map { userMapper.toUser(it) }

    override fun getByDocument(document: String) = userMongoRepository.getByDocument(document)
        .map { userMapper.toUser(it) }

    override fun delete(id: UUID) = userMongoRepository.deleteById(id)

    override fun save(user: User) = user.toMono()
        .map { userMapper.toUserEntity(it) }
        .flatMap { userMongoRepository.insert(it) }
        .map { userMapper.toUser(it) }

    override fun update(id: UUID, user: User) = user.toMono()
        .flatMap { userMongoRepository.findById(id) }
        .switchIfEmpty { Mono.empty() }
        .map { updateFields(user, it) }
        .flatMap { userMongoRepository.save(it) }
        .map { userMapper.toUser(it) }

    private fun updateFields(user: User, userEntity: UserEntity): UserEntity {
        userEntity.lastName = user.lastName
        userEntity.nickname = user.nickname
        userEntity.document = user.document
        userEntity.firstName = user.firstName

        return userEntity
    }
}