package com.sopt.welaaa.presentation.home.view

import android.content.ContentValues
import android.util.Log
import android.view.View
import com.sopt.welaaa.R
import com.sopt.welaaa.data.api.ApiClient
import com.sopt.welaaa.data.repository.GetBookListAdapter_1
import com.sopt.welaaa.data.repository.GetBookListAdapter_2
import com.sopt.welaaa.data.repository.GetBookListAdapter_3
import com.sopt.welaaa.databinding.FragmentHomeBinding
import com.sopt.welaaa.util.binding.BindingFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {


    //    private val model: BookViewModel by viewModels()
    private val getBookService = ApiClient.ServicePool.getBookService
    private val recyclerAdapter_1 = GetBookListAdapter_1()
    private val recyclerAdapter_2 = GetBookListAdapter_2()
    private val recyclerAdapter_3 = GetBookListAdapter_3()


    override fun getView(): View? {
        val recyclerView1 = binding.recyclerView1
        recyclerView1.adapter = recyclerAdapter_1

        val recyclerView2 = binding.recyclerView2
        recyclerView2.adapter = recyclerAdapter_2

        val recyclerView3 = binding.recyclerView3
        recyclerView3.adapter = recyclerAdapter_3

        getBookListFromAPI()

        return super.getView()

    }

    private fun getBookListFromAPI() {

        getBookService.also {
            CoroutineScope(Dispatchers.Main).launch {
                runCatching { it.getBookList() }
                    .onSuccess {
                        Log.d(ContentValues.TAG, "success")
                        recyclerAdapter_1.submitList(it.body()?.data)
                        recyclerAdapter_2.submitList(it.body()?.data)
                        recyclerAdapter_3.submitList(it.body()?.data)
                    }
                    .onFailure {
                        Log.d(ContentValues.TAG, "fail")
                    }
            }
        }

    }

}


