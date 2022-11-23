package com.sopt.welaaa.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchDTO(
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
        @SerialName("category")
        val category: String,
        @SerialName("description")
        val description: String,
        @SerialName("image")
        val image: Int
    )
}
