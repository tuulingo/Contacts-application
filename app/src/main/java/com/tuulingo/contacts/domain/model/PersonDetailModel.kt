package com.tuulingo.contacts.domain.model

import com.tuulingo.contacts.data.remote.dto.Email
import com.tuulingo.contacts.data.remote.dto.Phone

data class PersonDetailModel(
    val personDetailId: Int,
    val pictureUrl: String,
    val firstName: String,
    val lastName: String,
    val orgName: String,
    val phone: List<Phone>,
    val email: List<Email>,
    val closedDealsCount: Int,
    val openDealsCount: Int,
    val ownerName: String,
    val ownerEmail: String
    )
