package com.tuulingo.contacts.domain.repository

import com.tuulingo.contacts.common.Resource
import com.tuulingo.contacts.domain.model.PersonDetailModel
import com.tuulingo.contacts.domain.model.PersonModel
import kotlinx.coroutines.flow.Flow

interface PersonRepository {

    suspend fun getPersons(): Flow<Resource<List<PersonModel>>>

    suspend fun getPersonDetail(personId: String): Flow<Resource<PersonDetailModel>>
}