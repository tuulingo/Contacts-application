package com.tuulingo.contacts.data.remote.dto.personListDto


import com.google.gson.annotations.SerializedName

data class AdditionalData(
    @SerializedName("pagination")
    val pagination: Pagination
)