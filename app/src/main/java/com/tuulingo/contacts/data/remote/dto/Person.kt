package com.tuulingo.contacts.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("additional_data")
    val additionalData: AdditionalData,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("related_objects")
    val relatedObjects: RelatedObjects,
    @SerializedName("success")
    val success: Boolean
)