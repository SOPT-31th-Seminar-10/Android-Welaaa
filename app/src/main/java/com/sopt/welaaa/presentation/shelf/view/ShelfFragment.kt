package com.sopt.welaaa.presentation.shelf.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sopt.welaaa.R
import com.sopt.welaaa.databinding.FragmentShelfBinding
import com.sopt.welaaa.presentation.shelf.adpter.ShelfAdapter
import com.sopt.welaaa.presentation.shelf.viewmodel.ShelfViewModel
import com.sopt.welaaa.util.binding.BindingFragment

class ShelfFragment : Fragment() {
    private var _binding: FragmentShelfBinding? = null
    private val binding: FragmentShelfBinding
        get() = _binding!!

    private val shelfViewModel by viewModels<ShelfViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShelfBinding.inflate(inflater, container, false)
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
        shelfViewModel.getShelf()
    }

    private var shelfAdapter: ShelfAdapter = ShelfAdapter()

    private fun initAdapter() {
        binding.rvShelf.adapter = shelfAdapter
    }

    private fun setObserver() {
        shelfViewModel.shelfResult.observe(viewLifecycleOwner) {
            shelfAdapter.submitList(it.data.toMutableList())
        }
    }
}