package com.meiodecampo.person.adapters.out.repository.mongoRepository

import com.meiodecampo.person.adapters.out.repository.entities.UserEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.*

@Repository
interface UserMongoRepository : ReactiveMongoRepository<UserEntity, UUID> {
    fun getByDocument(document: String): Mono<UserEntity>
}