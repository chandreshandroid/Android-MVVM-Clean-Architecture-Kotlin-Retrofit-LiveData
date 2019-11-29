package com.example.mvvm_kotlin_retrofit_livedata.util

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

class ImageUtil {
    companion object
    {
        @BindingAdapter("app:imageurl")
        @JvmStatic
        fun setImageUrl(simpleDraweeView: SimpleDraweeView, url:String)
        {
            simpleDraweeView.setImageURI(url)
        }
    }
}