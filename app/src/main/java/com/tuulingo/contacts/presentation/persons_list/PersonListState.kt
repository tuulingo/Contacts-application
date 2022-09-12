package com.tuulingo.contacts.presentation.persons_list

import com.tuulingo.contacts.domain.model.PersonModel

data class PersonListState(
    val isLoading: Boolean = false,
    val persons: List<PersonModel> = emptyList(),
    val error: String = ""
)
