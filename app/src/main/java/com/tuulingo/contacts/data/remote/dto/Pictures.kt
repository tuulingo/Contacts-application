package com.tuulingo.contacts.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Pictures(
    @SerializedName("128")
    val x128: String,
    @SerializedName("512")
    val x512: String
)