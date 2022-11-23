package com.sopt.welaaa.presentation.bookdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.welaaa.data.model.Keyword
import com.sopt.welaaa.databinding.ItemKeywordBookDetailBinding
import com.sopt.welaaa.util.ItemDiffCallback

class KeywordAdapter :
    ListAdapter<Keyword, KeywordAdapter.KeywordViewHolder>(ItemDiffCallback<Keyword>(
        onItemsTheSame = { oldItem, newItem -> oldItem == newItem },
        onContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    )) {
    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeywordViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        return KeywordViewHolder(ItemKeywordBookDetailBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: KeywordViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    class KeywordViewHolder(private val binding: ItemKeywordBookDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(keyword: Keyword) {
            binding.keyword = keyword
            binding.executePendingBindings()
        }
    }
}