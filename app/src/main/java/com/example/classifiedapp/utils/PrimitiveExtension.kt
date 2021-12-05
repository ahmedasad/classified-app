package com.example.classifiedapp.utils

import android.content.Context
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import androidx.core.content.ContextCompat
import com.example.classifiedapp.R
import java.text.DecimalFormat


fun getCommaSeparatedPrice(context: Context, price: String): SpannableString {
    val splitedPrice = price.split(" ")
    var finalPrice =
        "${splitedPrice[0]} ${splitedPrice[1].toInt().getCommaSeparatedDigit()} \n / per item"
    val text = SpannableString(finalPrice)
    text.setSpan(RelativeSizeSpan(0.6f), finalPrice.length - 11, finalPrice.length, 0)
    text.setSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.orange)), 0, 3, 0)
    return text
}

fun Int.getCommaSeparatedDigit(): String {
    val formatter = DecimalFormat("#,###,###")
    return formatter.format(this)

}