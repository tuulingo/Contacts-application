package com.tuulingo.contacts.domain.model

import com.tuulingo.contacts.data.remote.dto.personDetailDto.Email
import com.tuulingo.contacts.data.remote.dto.personDetailDto.Phone


data class PersonDetailModel(
    val personId: String,
    val pictureUrl: String?,
    val firstName: String,
    val lastName: String,
    val orgName: String,
    val phones: List<Phone>,
    val emails: List<Email>,
    val closedDealsCount: Int,
    val openDealsCount: Int,
    val ownerName: String,
    val ownerEmail: String
    )
