package com.tuulingo.contacts.presentation.person_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuulingo.contacts.common.Constants
import com.tuulingo.contacts.common.Resource
import com.tuulingo.contacts.data.repository.PersonRepositoryImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class PersonDetailViewModel @Inject constructor(
    private val repositoryImpl: PersonRepositoryImpl,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PersonDetailState())
    val state: State<PersonDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_PERSON_ID)?.let { personId ->
            viewModelScope.launch {
                getPerson(personId)
            }
        }
    }

    private suspend fun getPerson(personId: String) {
        repositoryImpl.getPersonDetail(personId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PersonDetailState(person = result.data)
                }
                is Resource.Error -> {
                    _state.value = PersonDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PersonDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}