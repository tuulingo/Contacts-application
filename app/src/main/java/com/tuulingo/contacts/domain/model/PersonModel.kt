package com.tuulingo.contacts.domain.model

import com.tuulingo.contacts.data.remote.dto.personListDto.Phone

data class PersonModel(
    val id: String,
    val pictureUrl: String?,
    val firstName: String,
    val lastName: String,
    val phones: List<Phone>
)
