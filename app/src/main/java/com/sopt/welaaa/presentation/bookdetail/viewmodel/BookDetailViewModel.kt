package com.sopt.welaaa.presentation.bookdetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.welaaa.data.api.ApiClient
import com.sopt.welaaa.data.api.BookDetailService
import com.sopt.welaaa.data.model.*
import com.sopt.welaaa.util.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookDetailViewModel : ViewModel() {
    private val bookDetailService = ApiClient.getRetrofit().create(BookDetailService::class.java)

    private val bookDetailList = listOf<BookDetail>(
        BookDetail(description = "거짓말"),
        BookDetail(description = "거짓말"),
        BookDetail(description = "거짓말")
    )

    private val bookDescriptionList = listOf<BookDescription>(
        BookDescription(), BookDescription()
    )

    private val keywordList = listOf<Keyword>(
        Keyword("파친코"), Keyword("사전연재"), Keyword("재일조선"),
        Keyword("대하소설"), Keyword("장편소설"), Keyword("재미교포 작가"), Keyword("베스트셀러"),
        Keyword("애플TV"), Keyword("조선"), Keyword("선자"), Keyword("고한수"), Keyword("백이삭")
    )

    private val _bookDetailInfo = MutableLiveData<BookDetailInfo>()
    val bookDetailInfo: LiveData<BookDetailInfo>
        get() = _bookDetailInfo

    private val _bookDetailInfoEvent = MutableLiveData<Event<Int?>>()
    val bookDetailInfoEvent: LiveData<Event<Int?>>
        get() = _bookDetailInfoEvent

    fun getBookDetailList(): List<BookDetail> {
        return bookDetailList
    }

    fun getBookDescriptionList(): List<BookDescription> {
        return bookDescriptionList
    }

    fun getKeywordList(): List<Keyword> {
        return keywordList
    }

    fun getBookDetailInfo(bookId: Int) {
        bookDetailService.getBookDetailInfo(bookId).enqueue(object : Callback<BookDetailResponse> {
            override fun onResponse(
                call: Call<BookDetailResponse>,
                response: Response<BookDetailResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()!!
                    _bookDetailInfo.value = result.data
                } else {
                    _bookDetailInfoEvent.value = Event(response.code())
                }
            }

            override fun onFailure(call: Call<BookDetailResponse>, t: Throwable) {
                _bookDetailInfoEvent.value = Event(null)
            }
        })
    }
}