package com.tuulingo.contacts.data.repository

import com.tuulingo.contacts.common.Constants.API_TOKEN
import com.tuulingo.contacts.common.Resource
import com.tuulingo.contacts.data.remote.PipedriveApi
import com.tuulingo.contacts.data.remote.dto.toPersonDetail
import com.tuulingo.contacts.data.remote.dto.toPersonsData
import com.tuulingo.contacts.domain.model.PersonDetailModel
import com.tuulingo.contacts.domain.model.PersonModel
import com.tuulingo.contacts.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(
    private val api: PipedriveApi
): PersonRepository {
    override suspend fun getPersons(): Flow<Resource<List<PersonModel>>> {
        return flow {
            try {
                emit(Resource.Loading<List<PersonModel>>())
                val persons = api.getPersons(API_TOKEN).map { it.toPersonsData() }
                emit(Resource.Success<List<PersonModel>>(persons))
            } catch (e: HttpException) {
                emit(Resource.Error<List<PersonModel>>(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error<List<PersonModel>>("Couldn't reach server. Check your internet connection"))
            }
        }
    }

    override suspend fun getPersonDetail(personId: String): Flow<Resource<PersonDetailModel>> {
        return flow {
            try {
                emit(Resource.Loading<PersonDetailModel>())
                val person = api.getPersonDetail(API_TOKEN, personId).toPersonDetail()
                emit(Resource.Success<PersonDetailModel>(person))
            } catch (e: HttpException) {
                emit(Resource.Error<PersonDetailModel>(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error<PersonDetailModel>("Couldn't reach server. Check your internet connection"))
            }
        }
    }
}