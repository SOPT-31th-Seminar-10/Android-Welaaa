package com.sopt.welaaa.data.repository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.welaaa.data.model.ResponseBookDto
import com.sopt.welaaa.databinding.ItemRcyler1Binding
import com.sopt.welaaa.databinding.ItemRcyler2Binding

class GetBookListAdapter_2 :
    ListAdapter<ResponseBookDto.Data, GetBookListAdapter_2.ItemViewHolder>(Differ()) {


    inner class ItemViewHolder(val binding: ItemRcyler2Binding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(bookList: ResponseBookDto.Data) {

            with(binding) {
                homeBook = bookList
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRcyler2Binding.inflate(inflater)

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
