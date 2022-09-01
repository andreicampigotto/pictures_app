package com.example.picturesapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImageResponse(
    @SerializedName("data")
    val data: List<Data>
)

data class Data(
    @SerializedName("images")
    val images: List<Image>
): Serializable

data class Image(
    @SerializedName("id")
    val id: String,
    @SerializedName("link")
    val link: String
) : Serializable






