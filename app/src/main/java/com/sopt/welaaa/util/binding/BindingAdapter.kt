package com.sopt.welaaa.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:bookImage")
fun loadBookImage(view: ImageView, imageUrl: String) {
    Glide
        .with(view.context)
        .load(imageUrl)
        .into(view)
}