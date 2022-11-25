package com.sopt.welaaa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BookDetailResponse(
    val status: Int,
    val message: String,
    val data: BookDetailInfo
)

@Serializable
data class BookDetailInfo(
    val id: Int,
    val title: String,
    val image: String,
    val description: String,
    val bookIntroduct: String,
    val authorId: Int,
    val name: String,
    val authorIntroduct: String
)

data class BookDetail(
    val imageUrl: String = "",
    val description: String
)

data class Keyword(
    val description: String
)

data class BookDescription(
    val imageUrl: String = ""
)