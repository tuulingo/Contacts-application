package com.tuulingo.contacts.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("more_items_in_collection")
    val moreItemsInCollection: Boolean,
    @SerializedName("next_start")
    val nextStart: Int,
    @SerializedName("start")
    val start: Int
)