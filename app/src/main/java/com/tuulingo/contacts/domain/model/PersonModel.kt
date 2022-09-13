package com.tuulingo.contacts.domain.model

import com.tuulingo.contacts.data.remote.dto.Phone

data class PersonModel(
    val id: Int,
    val pictureUrl: String?,
    val firstName: String,
    val lastName: String,
    val phones: List<Phone>
)
