package com.tuulingo.contacts.presentation.persons_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuulingo.contacts.common.Resource
import com.tuulingo.contacts.data.repository.PersonRepositoryImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class PersonListViewModel @Inject constructor(
    private val repositoryImpl: PersonRepositoryImpl
) : ViewModel() {

    private val _state = mutableStateOf(PersonListState())
    val state: State<PersonListState> = _state

    init {
        viewModelScope.launch {
            getPersons()
        }
    }

    private suspend fun getPersons() {
        repositoryImpl.getPersons().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = PersonListState(persons = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = PersonListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = PersonListState(error = result.message ?: "An unexpected error occured")
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }
}