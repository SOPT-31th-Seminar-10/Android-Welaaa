package com.sopt.welaaa.presentation.home.view

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import com.sopt.welaaa.R
import com.sopt.welaaa.data.api.ApiClient
import com.sopt.welaaa.databinding.FragmentHomeBinding
import com.sopt.welaaa.presentation.bookdetail.view.BookDetailFragment
import com.sopt.welaaa.presentation.home.OnBookLikeRecordItemClickListener
import com.sopt.welaaa.presentation.home.adapter.BookLikeRecordAdapter
import com.sopt.welaaa.presentation.home.adapter.BookListenAdapter
import com.sopt.welaaa.presentation.home.adapter.BookMonthAdapter
import com.sopt.welaaa.util.binding.BindingFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    //    private val model: BookViewModel by viewModels()
    private val getBookService = ApiClient.ServicePool.getBookService
    private val bookLikeAdapter = BookLikeRecordAdapter()
    private val bookRecordAdapter = BookLikeRecordAdapter()
    private val bookListenAdapter = BookListenAdapter()
    private val bookMonthAdapter = BookMonthAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapters()
        getBookListFromAPI()
    }

    private fun setAdapters() {
        val recyclerviewListen = binding.recyclerviewListen
        recyclerviewListen.adapter = bookListenAdapter

        val recyclerviewLike = binding.recyclerviewLike
        bookLikeAdapter.setOnBookLikeRecordItemClickListener(object :
            OnBookLikeRecordItemClickListener {
            override fun onItemClick() {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fcv_main, BookDetailFragment())
                    .commit()
            }
        })
        recyclerviewLike.adapter = bookLikeAdapter

        val recyclerviewMonth = binding.recyclerviewMonth
        recyclerviewMonth.adapter = bookMonthAdapter

        val recyclerviewRecord = binding.recyclerviewRecord
        recyclerviewRecord.adapter = bookRecordAdapter
    }

    private fun getBookListFromAPI() {
        getBookService.also {
            CoroutineScope(Dispatchers.Main).launch {
                runCatching { it.getBookList() }
                    .onSuccess {
                        Log.d(ContentValues.TAG, "success")
                        bookLikeAdapter.submitList(it.body()?.data)
                        bookListenAdapter.submitList(it.body()?.data)
                        bookMonthAdapter.submitList(it.body()?.data)
                        bookRecordAdapter.submitList(it.body()?.data)
                    }
                    .onFailure {
                        Log.d(ContentValues.TAG, "fail")
                    }
            }
        }
    }
}


