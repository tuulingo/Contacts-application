package com.tuulingo.contacts.domain.model

import com.tuulingo.contacts.data.remote.dto.Phone

data class PersonModel(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: List<Phone>
)
