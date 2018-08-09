package com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.widget

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.view.View

fun Context.getColorById(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}

fun View.getColor(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this.context, id)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}