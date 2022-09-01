package com.example.picturesapp.di

import com.example.picturesapp.repository.ImgRepository
import com.example.picturesapp.service.ImgAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.imgur.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideImg(retrofit: Retrofit): ImgAPI = retrofit.create(ImgAPI::class.java)

    @Provides
    fun provideImgRepository(service: ImgAPI): ImgRepository =
        ImgRepository(service)
}