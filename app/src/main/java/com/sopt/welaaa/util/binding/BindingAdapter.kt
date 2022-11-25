package com.sopt.welaaa.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sopt.welaaa.data.model.ResponseBookDto

@BindingAdapter("app:bookImage")
fun loadBookImage(view: ImageView, imageUrl: String) {
    Glide
        .with(view.context)
        .load(imageUrl)
        .into(view)
}


@BindingAdapter("app:bookImageCircle")
fun loadBookImage2(view: ImageView, imageUrl: String) {
    imageUrl.let {
        Glide
            .with(view.context)
            .load(imageUrl)
            .circleCrop()
            .centerCrop()
            .into(view)
    }

}