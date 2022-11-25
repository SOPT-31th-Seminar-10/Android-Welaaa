package com.sopt.welaaa.presentation.bookdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.welaaa.data.model.BookDetail
import com.sopt.welaaa.databinding.ItemBookBookDetailBinding
import com.sopt.welaaa.util.ItemDiffCallback

class BookDetailAdapter : ListAdapter<BookDetail, BookDetailAdapter.BookDetailViewHolder>(
    ItemDiffCallback<BookDetail>(
        onItemsTheSame = { oldItem, newItem -> oldItem == newItem },
        onContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    )
) {
    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookDetailViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        return BookDetailViewHolder(ItemBookBookDetailBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BookDetailViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    class BookDetailViewHolder(private val binding: ItemBookBookDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(bookDetail: BookDetail) {
            binding.bookDetail = bookDetail
            binding.executePendingBindings()
        }
    }
}