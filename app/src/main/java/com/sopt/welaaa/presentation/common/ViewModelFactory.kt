package com.sopt.welaaa.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sopt.welaaa.presentation.bookdetail.viewmodel.BookDetailViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(BookDetailViewModel::class.java) -> BookDetailViewModel() as T
            else -> throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
        }
    }
}