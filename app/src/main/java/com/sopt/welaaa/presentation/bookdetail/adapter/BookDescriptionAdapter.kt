package com.sopt.welaaa.presentation.bookdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.welaaa.data.model.BookDescription
import com.sopt.welaaa.databinding.ItemDescriptionBookDetailBinding
import com.sopt.welaaa.util.ItemDiffCallback

class BookDescriptionAdapter :
    ListAdapter<BookDescription, BookDescriptionAdapter.BookDescriptionViewHolder>(
        ItemDiffCallback<BookDescription>(
            onItemsTheSame = { oldItem, newItem -> oldItem == newItem },
            onContentsTheSame = { oldItem, newItem -> oldItem == newItem }
        )
    ) {
    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookDescriptionViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        return BookDescriptionViewHolder(
            ItemDescriptionBookDetailBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookDescriptionViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    class BookDescriptionViewHolder(private val binding: ItemDescriptionBookDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(bookDescription: BookDescription) {
            binding.bookDescription = bookDescription
            binding.executePendingBindings()
        }
    }
}