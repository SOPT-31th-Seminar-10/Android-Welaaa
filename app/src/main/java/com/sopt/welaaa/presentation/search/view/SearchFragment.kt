package com.sopt.welaaa.presentation.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sopt.welaaa.databinding.FragmentSearchBinding
import com.sopt.welaaa.presentation.search.adapter.SearchAdapter
import com.sopt.welaaa.presentation.search.viewmodel.SearchViewModel

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding!!

    private val searchViewModel by viewModels<SearchViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        initAdapter()
        initView()
        setObserver()
    }

    private fun initView() {
        searchViewModel.getSearch()
    }

    private var searchAdapter: SearchAdapter = SearchAdapter()

    private fun initAdapter() {
        binding.rvSearch.adapter = searchAdapter
    }

    private fun setObserver() {
        searchViewModel.searchResult.observe(viewLifecycleOwner) {
            searchAdapter.submitList(it.data.toMutableList())
        }
    }

    //프래그먼트는 뷰보다 더 오래 살아남기 때문에 바인딩 클래스는 뷰에 대한 참조를 가지고 있음
    //뷰가 제거될 때 즉 onDestroyView() 메서드가 작동할 때 이 바인딩 클래스의 인스턴스도 같이 정리해줌
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}