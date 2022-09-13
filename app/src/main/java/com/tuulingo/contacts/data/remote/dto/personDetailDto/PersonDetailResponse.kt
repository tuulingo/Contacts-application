package com.tuulingo.contacts.data.remote.dto.personDetailDto


import com.google.gson.annotations.SerializedName

data class PersonDetailResponse(
    @SerializedName("additional_data")
    val additionalData: AdditionalData,
    @SerializedName("data")
    val data: Data,
    @SerializedName("related_objects")
    val relatedObjects: RelatedObjects,
    @SerializedName("success")
    val success: Boolean
)