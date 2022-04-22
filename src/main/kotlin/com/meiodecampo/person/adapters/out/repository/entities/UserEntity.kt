package com.meiodecampo.person.adapters.out.repository.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class UserEntity(
    @Id
    var id: UUID,
    var firstName: String,
    var lastName: String,
    var nickname: String,
    var document: String)