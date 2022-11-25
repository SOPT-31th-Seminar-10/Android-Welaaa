package com.sopt.welaaa.data.api

import com.sopt.welaaa.data.model.ResponseSearchDTO
import retrofit2.Call
import retrofit2.http.GET

interface SearchService {
    //search API
    @GET("category")
    fun getSearch(): Call<ResponseSearchDTO>
}