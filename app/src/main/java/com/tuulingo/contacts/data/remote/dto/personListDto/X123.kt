package com.tuulingo.contacts.data.remote.dto.personListDto


import com.google.gson.annotations.SerializedName

data class X123(
    @SerializedName("active_flag")
    val activeFlag: Boolean,
    @SerializedName("email")
    val email: String,
    @SerializedName("has_pic")
    val hasPic: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("pic_hash")
    val picHash: String
)