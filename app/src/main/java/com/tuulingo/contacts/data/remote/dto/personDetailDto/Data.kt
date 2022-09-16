package com.tuulingo.contacts.data.remote.dto.personDetailDto


import com.google.gson.annotations.SerializedName
import com.tuulingo.contacts.domain.model.PersonDetailModel

data class Data(
    @SerializedName("active_flag")
    val activeFlag: Boolean,
    @SerializedName("activities_count")
    val activitiesCount: Int,
    @SerializedName("add_time")
    val addTime: String,
    @SerializedName("cc_email")
    val ccEmail: String,
    @SerializedName("closed_deals_count")
    val closedDealsCount: Int,
    @SerializedName("company_id")
    val companyId: Int,
    @SerializedName("done_activities_count")
    val doneActivitiesCount: Int,
    @SerializedName("email")
    val email: List<Email>,
    @SerializedName("email_messages_count")
    val emailMessagesCount: Int,
    @SerializedName("files_count")
    val filesCount: Int,
    @SerializedName("first_char")
    val firstChar: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("followers_count")
    val followersCount: Int,
    @SerializedName("id")
    val personId: Int,
    @SerializedName("label")
    val label: Int,
    @SerializedName("last_activity_date")
    val lastActivityDate: Any,
    @SerializedName("last_activity_id")
    val lastActivityId: Any,
    @SerializedName("last_incoming_mail_time")
    val lastIncomingMailTime: Any,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("last_outgoing_mail_time")
    val lastOutgoingMailTime: Any,
    @SerializedName("lost_deals_count")
    val lostDealsCount: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("next_activity_date")
    val nextActivityDate: Any,
    @SerializedName("next_activity_id")
    val nextActivityId: Any,
    @SerializedName("next_activity_time")
    val nextActivityTime: Any,
    @SerializedName("notes_count")
    val notesCount: Int,
    @SerializedName("open_deals_count")
    val openDealsCount: Int,
    @SerializedName("org_id")
    val orgId: OrgId,
    @SerializedName("org_name")
    val orgName: String,
    @SerializedName("owner_id")
    val ownerId: OwnerId,
    @SerializedName("owner_name")
    val ownerName: String,
    @SerializedName("participant_closed_deals_count")
    val participantClosedDealsCount: Int,
    @SerializedName("participant_open_deals_count")
    val participantOpenDealsCount: Int,
    @SerializedName("phone")
    val phone: List<Phone>,
    @SerializedName("picture_id")
    val pictureId: PictureId,
    @SerializedName("primary_email")
    val primaryEmail: String,
    @SerializedName("related_closed_deals_count")
    val relatedClosedDealsCount: Int,
    @SerializedName("related_lost_deals_count")
    val relatedLostDealsCount: Int,
    @SerializedName("related_open_deals_count")
    val relatedOpenDealsCount: Int,
    @SerializedName("related_won_deals_count")
    val relatedWonDealsCount: Int,
    @SerializedName("undone_activities_count")
    val undoneActivitiesCount: Int,
    @SerializedName("update_time")
    val updateTime: String,
    @SerializedName("visible_to")
    val visibleTo: String,
    @SerializedName("won_deals_count")
    val wonDealsCount: Int
)

fun Data.toPersonDetail() : PersonDetailModel {
    return PersonDetailModel(
        personId = personId.toString(),
        pictureUrl =   pictureId?.let { it.pictures.x512  },
        firstName = firstName,
        lastName = lastName,
        orgName = orgName,
        phones = phone,
        emails = email,
        closedDealsCount = closedDealsCount,
        openDealsCount = openDealsCount,
        ownerName = ownerName,
        ownerEmail = ownerId.email
    )
}
