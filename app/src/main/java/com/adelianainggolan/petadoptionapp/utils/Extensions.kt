package com.adelianainggolan.petadoptionapp.utils

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.setImage(context: Context, @DrawableRes imageRes: Int) {
    Glide.with(context)
        .load(imageRes)
        .into(this)
}