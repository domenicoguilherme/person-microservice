package com.meiodecampo.person.core.domain.models

import java.util.*

class User(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val document: String
    )