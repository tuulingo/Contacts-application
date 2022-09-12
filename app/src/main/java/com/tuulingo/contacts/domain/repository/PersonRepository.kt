package com.tuulingo.contacts.domain.repository

import Resource
import com.tuulingo.contacts.domain.model.PersonDetailModel
import com.tuulingo.contacts.domain.model.PersonModel
import kotlinx.coroutines.flow.Flow

interface PersonRepository {

    suspend fun getPerson(): Flow<Resource<List<PersonModel>>>

    suspend fun getPersonDetail(personId: Int): Flow<Resource<PersonDetailModel>>
}