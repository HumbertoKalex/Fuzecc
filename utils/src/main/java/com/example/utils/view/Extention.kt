package com.example.utils.view

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun ImageView.load(url: String, @DrawableRes placeHolder: Int) {
    Glide.with(this).load(url).fitCenter().placeholder(placeHolder).into(this@load)
}

fun String.convertToCurrentTimezone(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")
    val date = inputFormat.parse(this)
    val outputFormat = SimpleDateFormat("dd-MM HH:mm", Locale.getDefault())
    return outputFormat.format(date ?: Date()) ?: this
}
