package com.sopt.welaaa.data.api

import com.sopt.welaaa.data.model.BookDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BookDetailService {
    /**
     * 북 상세 조회 API
     */
    @GET("book/{bookId}")
    fun getBookDetailInfo(
        @Path("bookId") bookId: Int
    ): Call<BookDetailResponse>
}