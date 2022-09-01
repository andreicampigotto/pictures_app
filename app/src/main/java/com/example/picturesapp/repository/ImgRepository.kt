package com.example.picturesapp.repository

import com.example.picturesapp.BuildConfig.Authorization
import com.example.picturesapp.model.Data
import com.example.picturesapp.service.ImgAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ImgRepository @Inject constructor(
    private val service: ImgAPI
) {
    suspend fun getImages(): List<Data>? {
        return withContext(Dispatchers.Default) {
            val response = service.getImages(Authorization)
            val processResponse = processData(response)
            processResponse?.data
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}