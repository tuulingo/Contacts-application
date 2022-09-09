package com.tuulingo.contacts.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PipedriveApi {

    @GET("/api/v1/persons")
    suspend fun getPersons(
        @Query("api_token") api_token: String
    ): ResponseBody

    @GET("/api/v1/persons/{id}")
    suspend fun getPersonDetail(
        @Path("id") personId: String,
        @Query("api_token") api_token: String
    ): ResponseBody

}