package com.example.picturesapp.repository

import com.example.picturesapp.BuildConfig.Authorization
import com.example.picturesapp.model.ImageResponse
import com.example.picturesapp.service.ImgAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ImgRepository @Inject constructor(
    private val service: ImgAPI
) {

    suspend fun getCatsImages(): ImageResponse? {
        return withContext(Dispatchers.Default) {
            val response = service.getCatsImages(
                Authorization
            )
            processData(response)
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}