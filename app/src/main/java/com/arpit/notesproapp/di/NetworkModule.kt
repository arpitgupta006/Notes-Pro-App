package com.arpit.notesproapp.di

import com.arpit.notesproapp.api.UserAPI
import com.arpit.notesproapp.utils.Constants.BASE_URL
import dagger.Component.Builder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()
    }

    @Singleton
    @Provides
    fun providesUserAPI(retrofit: Retrofit) : UserAPI{
        return retrofit.create(UserAPI::class.java)
    }
}