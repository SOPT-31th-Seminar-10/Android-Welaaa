package com.sopt.welaaa.presentation.search.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.welaaa.data.api.SearchRepo
import com.sopt.welaaa.data.model.ResponseSearchDTO
import com.sopt.welaaa.databinding.ItemBodySearchBinding

class SearchAdapter(context: Context) : RecyclerView.Adapter<SearchAdapter.BodyViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    //private var searchList: List<ResponseSearchDTO.Book> = emptyList()
    private var userList: List<SearchRepo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodyViewHolder {
        val binding = ItemBodySearchBinding.inflate(inflater, parent, false)
        return BodyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BodyViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    //override fun getItemCount(): Int = searchList.size
    override fun getItemCount(): Int = userList.size

    /*fun setSearchList(searchList: List<ResponseSearchDTO.Book>) {
        this.searchList = searchList.toList()
        notifyDataSetChanged()
    }*/

    fun replaceList(newList: List<SearchRepo>) {
        userList = newList.toList()
        notifyDataSetChanged()
    }

    class BodyViewHolder(
        private val binding: ItemBodySearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        //fun onBind(book:ResponseSearchDTO.Book) {
        fun onBind(book: SearchRepo) {
            /*Glide.with(this.binding.root)
                .load(book.category)
                .load(book.description)
                .into(binding.ivShelfBook)*/
            binding.tvBookCategory.text = book.category
            binding.tvBookDescription.text = book.description
            binding.ivShelfBook.setImageResource(book.image)
        }
    }
}