package com.sopt.welaaa.presentation.shelf.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.welaaa.data.api.ApiClient
import com.sopt.welaaa.data.api.ShelfService
import com.sopt.welaaa.data.model.ResponseShelfDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShelfViewModel : ViewModel() {
    private val _shelfResult: MutableLiveData<ResponseShelfDTO> = MutableLiveData()
    val shelfResult: LiveData<ResponseShelfDTO>
    get() = _shelfResult
    private val shelfService = ApiClient.getRetrofit().create(ShelfService::class.java)

    fun getShelf() {
        // 책 리스트 API 연결
        shelfService.getShelf()
            .enqueue(object : Callback<ResponseShelfDTO> {
                override fun onResponse(
                    call: Call<ResponseShelfDTO>,
                    response: Response<ResponseShelfDTO>
                ) {
                    if (response.isSuccessful) {
                        Log.d("서버 통신 성공", response.message())
                        _shelfResult.value = response.body()
                    } else {
                    }
                }
                override fun onFailure(call: Call<ResponseShelfDTO>, t: Throwable) {
                    Log.d("서버 통신 실패", t.toString())
                }
            })
    }
}