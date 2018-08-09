package com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.johnnyfivedev.stackoverflowarchitecturecomponents.R


class ShadowPreloader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes) {

    init {
        setBackgroundResource(R.color.transparentBlack)

        val progressBar = ProgressBar(context)

        val params:FrameLayout.LayoutParams = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        params.gravity = Gravity.CENTER
        progressBar.setLayoutParams(params)

        progressBar.layoutParams.width = resources.getDimensionPixelSize(R.dimen.preloader_default_width_height)

        addView(progressBar)
    }
}