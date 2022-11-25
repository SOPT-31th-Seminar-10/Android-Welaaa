package com.sopt.welaaa.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.welaaa.data.model.ResponseSearchDTO
import com.sopt.welaaa.databinding.ItemBodySearchBinding
import com.sopt.welaaa.util.ItemDiffCallback

class SearchAdapter: ListAdapter<ResponseSearchDTO.Book, SearchAdapter.BodyViewHolder>(
    ItemDiffCallback<ResponseSearchDTO.Book>(
        onItemsTheSame = { oldItem, newItem -> oldItem == newItem },
        onContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    )
) {
    private lateinit var inflater: LayoutInflater
  //  private var searchList:List<ResponseSearchDTO.Book> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodyViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        return BodyViewHolder(ItemBodySearchBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BodyViewHolder, position: Int) {
        holder.onBind(getItem(position))
        //searchList()
    }

    //override fun getItemCount(): Int = searchList.size

    class BodyViewHolder(private val binding: ItemBodySearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(book: ResponseSearchDTO.Book) {
            Glide.with(this.binding.root)
                .load(book.image)
                .into(binding.ivShelfBook)
            binding.tvBookCategory.text = book.category
            binding.tvBookDescription.text = book.description
        }
    }
}