package com.tuulingo.contacts.data.remote.dto


import com.google.gson.annotations.SerializedName

data class RelatedObjects(
    @SerializedName("organization")
    val organization: Organization,
    @SerializedName("picture")
    val picture: Picture,
    @SerializedName("user")
    val user: User
)