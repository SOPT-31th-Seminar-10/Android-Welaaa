package com.sopt.welaaa.data.api

import com.sopt.welaaa.data.model.ResponseShelfDTO
import retrofit2.Call
import retrofit2.http.GET

interface ShelfService {
    //shelf API
    @GET("book")
    fun getShelf(): Call<ResponseShelfDTO>
}