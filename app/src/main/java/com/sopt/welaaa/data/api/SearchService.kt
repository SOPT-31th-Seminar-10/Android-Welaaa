package com.sopt.welaaa.data.api

import com.sopt.welaaa.data.model.ResponseSearchDTO
import retrofit2.Call
import retrofit2.http.GET

interface SearchService {
    @GET("report/all")
    fun getSearch(): Call<ResponseSearchDTO>
}