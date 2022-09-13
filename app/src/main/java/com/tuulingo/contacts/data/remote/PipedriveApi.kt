package com.tuulingo.contacts.data.remote

import com.tuulingo.contacts.data.remote.dto.Data
import com.tuulingo.contacts.data.remote.dto.FirstResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PipedriveApi {

    @GET("/api/v1/persons")
    suspend fun getPersons(
        @Query("api_token") api_token: String
    ): FirstResponse

    @GET("/api/v1/persons/{id}")
    suspend fun getPersonDetail(
        @Path("id") personId: String,
        @Query("api_token") api_token: String
    ): Data

}