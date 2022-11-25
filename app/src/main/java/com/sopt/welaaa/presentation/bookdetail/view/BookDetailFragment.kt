package com.sopt.welaaa.presentation.bookdetail.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sopt.welaaa.R
import com.sopt.welaaa.databinding.FragmentBookDetailBinding
import com.sopt.welaaa.presentation.bookdetail.adapter.BookDescriptionAdapter
import com.sopt.welaaa.presentation.bookdetail.adapter.BookDetailAdapter
import com.sopt.welaaa.presentation.bookdetail.adapter.KeywordAdapter
import com.sopt.welaaa.presentation.bookdetail.viewmodel.BookDetailViewModel
import com.sopt.welaaa.presentation.home.view.HomeFragment
import com.sopt.welaaa.util.EventObserver
import com.sopt.welaaa.util.binding.BindingFragment

class BookDetailFragment :
    BindingFragment<FragmentBookDetailBinding>(R.layout.fragment_book_detail) {
    private val viewModel: BookDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        initView()
        setObservers()
        setAdapters()
        setVisibility()
        setNavigation()
    }

    private fun setNavigation() {
        binding.fabBackBookDetail.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_main, HomeFragment())
                .commit()
        }
    }

    private fun initView() {
        viewModel.getBookDetailInfo(2)
    }

    private fun setObservers() {
        viewModel.bookDetailInfo.observe(
            viewLifecycleOwner
        ) { bookDetailInfo ->
            binding.bookDetailInfo = bookDetailInfo
        }
        viewModel.bookDetailInfoEvent.observe(
            viewLifecycleOwner, EventObserver { code ->
                when (code) {
                    400 -> Toast.makeText(
                        requireContext(),
                        R.string.failure_400,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    500 -> Toast.makeText(
                        requireContext(),
                        R.string.failure_500,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    null -> Toast.makeText(
                        requireContext(),
                        R.string.failure_network,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    else -> throw IllegalArgumentException("잘못된 응답값 입니다.")
                }
            }
        )
    }

    private fun setAdapters() {
        val bookDetailTopAdapter = BookDetailAdapter()
        bookDetailTopAdapter.submitList(viewModel.getBookDetailList())
        binding.rvSeriesBookDetail.adapter = bookDetailTopAdapter
        val bookDescriptionAdapter = BookDescriptionAdapter()
        bookDescriptionAdapter.submitList(viewModel.getBookDescriptionList())
        binding.rvDescriptionBookDetail.adapter = bookDescriptionAdapter
        val keywordAdapter = KeywordAdapter()
        keywordAdapter.submitList(viewModel.getKeywordList())
        binding.rvKeywordBookDetail.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
        binding.rvKeywordBookDetail.adapter = keywordAdapter
        val bookDetailBottomAdapter = BookDetailAdapter()
        bookDetailBottomAdapter.submitList(viewModel.getBookDetailList())
        binding.rvSeriesBottomBookDetail.adapter = bookDetailBottomAdapter
    }

    private fun setVisibility() {
        binding.ssvBookDetail.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
            if (scrollY > 1700) {
                binding.clMembershipBottomBookDetail.visibility = View.VISIBLE
            } else {
                binding.clMembershipBottomBookDetail.visibility = View.GONE
            }
        })
    }
}