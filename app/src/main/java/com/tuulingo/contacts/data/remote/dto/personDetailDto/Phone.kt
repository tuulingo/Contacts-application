package com.tuulingo.contacts.data.remote.dto.personDetailDto


import com.google.gson.annotations.SerializedName

data class Phone(
    @SerializedName("label")
    val label: String,
    @SerializedName("primary")
    val primary: Boolean,
    @SerializedName("value")
    val value: String
)