package com.tuulingo.contacts.presentation.person_detail

import com.tuulingo.contacts.domain.model.PersonDetailModel
import com.tuulingo.contacts.domain.model.PersonModel

data class PersonDetailState (
    val isLoading: Boolean = false,
    val person: PersonDetailModel? = null,
    val error: String = ""

)
