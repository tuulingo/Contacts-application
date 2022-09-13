package com.tuulingo.contacts.data.remote.dto.personListDto


import com.google.gson.annotations.SerializedName

data class X1X(
    @SerializedName("active_flag")
    val activeFlag: Boolean,
    @SerializedName("add_time")
    val addTime: String,
    @SerializedName("added_by_user_id")
    val addedByUserId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("item_id")
    val itemId: Int,
    @SerializedName("item_type")
    val itemType: String,
    @SerializedName("pictures")
    val pictures: Pictures,
    @SerializedName("update_time")
    val updateTime: String
)