package com.example.classifiedapp.utils

import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import java.text.DecimalFormat


fun getCommaSeparatedPrice(price:String):SpannableString{
    val splitedPrice = price.split(" ")
    var finalPrice = "${splitedPrice[0]} ${splitedPrice[1].toInt().getCommaSeparatedDigit()} \n per item"
    val text = SpannableString(finalPrice)
    text.setSpan(RelativeSizeSpan(0.6f),finalPrice.length-9,finalPrice.length,0)
    return text
}

fun Int.getCommaSeparatedDigit(): String {
    val formatter = DecimalFormat("#,###,###")
    return formatter.format(this)

}