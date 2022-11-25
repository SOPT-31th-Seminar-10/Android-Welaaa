package com.sopt.welaaa.presentation.shelf.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.welaaa.data.model.ResponseShelfDTO
import com.sopt.welaaa.databinding.ItemBodyShelfBinding
import com.sopt.welaaa.util.ItemDiffCallback

class ShelfAdapter : ListAdapter<ResponseShelfDTO.Book,ShelfAdapter.ShelfViewHolder>(
    ItemDiffCallback<ResponseShelfDTO.Book>(
        onItemsTheSame = { oldItem, newItem -> oldItem == newItem },
        onContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    )
) {
    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelfViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        return ShelfViewHolder(ItemBodyShelfBinding.inflate(inflater, parent, false))
    }
    override fun onBindViewHolder(holder: ShelfViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ShelfViewHolder(private val binding: ItemBodyShelfBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(book: ResponseShelfDTO.Book) {
            Glide.with(this.binding.root)
                .load(book.image)
                .into(binding.ivShelfBook)
            binding.tvBookTitle.text = book.title
            binding.tvBookAuthor.text = book.author
        }
    }
}