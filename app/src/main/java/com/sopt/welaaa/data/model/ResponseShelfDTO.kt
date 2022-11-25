package com.sopt.welaaa.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseShelfDTO(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Book>
) {
    @Serializable
    data class Book(
        @SerialName("id")
        val id: Int,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("image")
        val image: String,
        @SerialName("author")
        val author: String
    )
}
