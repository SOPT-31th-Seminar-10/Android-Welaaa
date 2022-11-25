package com.sopt.welaaa.presentation.search.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.welaaa.data.api.ApiClient
import com.sopt.welaaa.data.api.SearchService
import com.sopt.welaaa.data.model.ResponseSearchDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel: ViewModel() {
    private val _searchResult: MutableLiveData<ResponseSearchDTO> = MutableLiveData()
    val searchResult: LiveData<ResponseSearchDTO>
        get() = _searchResult
    private val searchService = ApiClient.getRetrofit().create(SearchService::class.java)

    fun getSearch() {
        // 책 리스트 API 연결
        searchService.getSearch()
            .enqueue(object : Callback<ResponseSearchDTO> {
                override fun onResponse(
                    call: Call<ResponseSearchDTO>,
                    response: Response<ResponseSearchDTO>
                ) {
                    if (response.isSuccessful) {
                        Log.d("서버 통신 성공", response.message())
                        _searchResult.value = response.body()
                    } else {
                    }
                }
                override fun onFailure(call: Call<ResponseSearchDTO>, t: Throwable) {
                    Log.d("서버 통신 실패", t.toString())
                }
            })
    }
}