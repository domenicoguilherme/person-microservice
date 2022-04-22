package com.meiodecampo.person.adapters.`in`.api.models.response

import java.util.*

class UserResponse(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val document: String
)