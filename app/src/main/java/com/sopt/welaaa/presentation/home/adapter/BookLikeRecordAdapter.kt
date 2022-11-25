package com.sopt.welaaa.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.welaaa.data.model.ResponseBookDto
import com.sopt.welaaa.databinding.ItemLikeRecordBinding
import com.sopt.welaaa.presentation.home.OnBookLikeRecordItemClickListener

class BookLikeRecordAdapter :
    ListAdapter<ResponseBookDto.Data, BookLikeRecordAdapter.ItemViewHolder>(Differ()) {
    private lateinit var onBookLikeRecordItemClickListener: OnBookLikeRecordItemClickListener

    fun setOnBookLikeRecordItemClickListener(onBookLikeRecordItemClickListener: OnBookLikeRecordItemClickListener) {
        this.onBookLikeRecordItemClickListener = onBookLikeRecordItemClickListener
    }

    inner class ItemViewHolder(val binding: ItemLikeRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(bookList: ResponseBookDto.Data) {
            binding.homeBook = bookList
            binding.clItemLikeCount.setOnClickListener {
                onBookLikeRecordItemClickListener.onItemClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLikeRecordBinding.inflate(inflater)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }


    class Differ() : DiffUtil.ItemCallback<ResponseBookDto.Data>() {
        override fun areItemsTheSame(
            oldItem: ResponseBookDto.Data,
            newItem: ResponseBookDto.Data
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ResponseBookDto.Data,
            newItem: ResponseBookDto.Data
        ): Boolean {
            return oldItem == newItem
        }

    }
}
