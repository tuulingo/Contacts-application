package com.tuulingo.contacts.data.remote.dto.personListDto


import com.google.gson.annotations.SerializedName

data class X1(
    @SerializedName("active_flag")
    val activeFlag: Boolean,
    @SerializedName("address")
    val address: String,
    @SerializedName("cc_email")
    val ccEmail: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("owner_id")
    val ownerId: Int,
    @SerializedName("people_count")
    val peopleCount: Int
)