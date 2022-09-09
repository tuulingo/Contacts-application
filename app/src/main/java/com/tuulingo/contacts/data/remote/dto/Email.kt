package com.tuulingo.contacts.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Email(
    @SerializedName("label")
    val label: String,
    @SerializedName("primary")
    val primary: Boolean,
    @SerializedName("value")
    val value: String
)