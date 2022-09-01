package com.example.picturesapp.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    val id: String,
    @SerializedName("imgUrl")
    val imgUrl: String
)

data class Data(
    @SerializedName("imagesList")
    val imagesList: List<Image>
)


data class ImageResponse(
    @SerializedName("data")
    val data: List<Data>
)


