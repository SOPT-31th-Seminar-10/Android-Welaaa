package com.sopt.welaaa.data.source

import com.sopt.welaaa.data.model.ResponseBookDto
import retrofit2.Response
import retrofit2.http.GET

interface GetBookService {
    @GET("/book")
    suspend fun getBookList(
    ): Response<ResponseBookDto>
}