package com.example.classifiedapp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("load_img")
fun loadImg(imgView:ImageView,url:String){
    Glide.with(imgView.context).load(url).into(imgView)
}

@BindingAdapter("set_price")
fun setPrice(view: TextView,price:String){
    view.text = getCommaSeparatedPrice(price)
}