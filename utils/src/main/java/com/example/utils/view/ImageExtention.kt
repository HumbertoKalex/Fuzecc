package com.example.utils.view

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.example.utils.R

fun ImageView.load(url: String, @DrawableRes placeHolder: Int) {
    Glide.with(this).load(url).centerCrop().placeholder(placeHolder).into(this@load)
}
