package com.sopt.welaaa.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBookDto(
    @SerialName("data")
    val data: List<Data>,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Int
) {
    @Serializable
    data class Data(
        @SerialName("author")
        val author: String,
        @SerialName("description")
        val description: String,
        @SerialName("id")
        val id: Int,
        @SerialName("image")
        val image: String,
        @SerialName("title")
        val title: String
    )
}