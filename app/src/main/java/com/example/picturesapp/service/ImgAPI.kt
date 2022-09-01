package com.example.picturesapp.service

import com.example.picturesapp.model.ImageList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ImgAPI {
    @GET("/3/gallery/search/?q=cats")
    suspend fun getImages(
        @Header("Authorization") key: String
    ): Response<ImageList>
}