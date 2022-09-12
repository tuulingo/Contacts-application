package com.tuulingo.contacts.di

import com.tuulingo.contacts.common.Constants
import com.tuulingo.contacts.data.remote.PipedriveApi
import com.tuulingo.contacts.data.repository.PersonRepositoryImpl
import com.tuulingo.contacts.domain.repository.PersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePipedriveApi(): PipedriveApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PipedriveApi::class.java)
    }

    @Provides
    @Singleton
    fun providePersonRepository(api: PipedriveApi): PersonRepository {
        return PersonRepositoryImpl(api)
    }

}