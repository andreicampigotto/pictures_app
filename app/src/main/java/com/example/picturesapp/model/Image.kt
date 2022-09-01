package com.example.picturesapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImageList(
    @SerializedName("data")
    val data: List<Image>
)

data class Image(
    @SerializedName("id")
    val id: String,
    @SerializedName("link")
    val link: String
) : Serializable






