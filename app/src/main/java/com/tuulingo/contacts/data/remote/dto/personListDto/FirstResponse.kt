package com.tuulingo.contacts.data.remote.dto.personListDto


import com.google.gson.annotations.SerializedName

data class FirstResponse(
    @SerializedName("additional_data")
    val additionalData: AdditionalData,
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("related_objects")
    val relatedObjects: RelatedObjects,
    @SerializedName("success")
    val success: Boolean
)