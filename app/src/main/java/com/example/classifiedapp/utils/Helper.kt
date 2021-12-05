package com.example.classifiedapp.utils

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.classifiedapp.R

object Helper {

    fun loadImg(imgView: ImageView, url: String) {
        val circularProgressDrawable = CircularProgressDrawable(imgView.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        val color = ContextCompat.getColor(imgView.context, R.color.theme_red)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            circularProgressDrawable.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP);
        else
            circularProgressDrawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);

        circularProgressDrawable.start()
        Glide.with(imgView.context).load(url).placeholder(circularProgressDrawable).into(imgView)
    }

    fun setPrice(view: TextView, price: String) {
        view.text = getCommaSeparatedPrice(view.context, price)
    }
}