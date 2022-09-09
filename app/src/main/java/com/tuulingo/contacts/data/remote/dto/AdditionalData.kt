package com.tuulingo.contacts.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AdditionalData(
    @SerializedName("dropbox_email")
    val dropboxEmail: String
)