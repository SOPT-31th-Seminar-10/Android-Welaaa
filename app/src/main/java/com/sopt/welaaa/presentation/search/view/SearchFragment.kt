package com.sopt.welaaa.presentation.search.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.sopt.welaaa.R
import com.sopt.welaaa.data.api.SearchRepo
import com.sopt.welaaa.databinding.FragmentSearchBinding
import com.sopt.welaaa.presentation.search.adapter.SearchAdapter
import com.sopt.welaaa.util.binding.BindingFragment

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding!!
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView( //onCreateView: 뷰껍데기 만들기
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        searchAdapter = SearchAdapter(requireContext())
        binding.rvSearch.adapter = searchAdapter
        initUserData()
    }

    /*val adapter = SearchAdapter(requireContext())
    binding.rvSearch.adapter = adapter //searchAdapter를 rvSearch(리사이클러뷰)과 연결
    initUserData()*/

    private fun initUserData() {
        searchAdapter.replaceList(
            listOf(
                //데이터 조작
                SearchRepo(1, "이달의 오디오북", "소설,인문,경제경영,자기계발,에세이...", R.drawable.iv_search_category_book),
                SearchRepo(2, "이달의 오디오북", "소설,인문,경제경영,자기계발,에세이...", R.drawable.iv_search_category_book),
                SearchRepo(3, "이달의 오디오북", "소설,인문,경제경영,자기계발,에세이...", R.drawable.iv_search_category_book)
            )
        )
    }

    //프래그먼트는 뷰보다 더 오래 살아남기 때문에 바인딩 클래스는 뷰에 대한 참조를 가지고 있음
//뷰가 제거될 때 즉 onDestroyView() 메서드가 작동할 때 이 바인딩 클래스의 인스턴스도 같이 정리해줌
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}