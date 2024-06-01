package com.tractive.android.app_6_kmeme.textstyles

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.tractive.android.app_6_kmeme.R

class TitleL @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    init {
        setTextAppearance(R.style.TitleL)
    }
}

class Title @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    init {
        setTextAppearance(R.style.Title)
    }
}

class Body @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    init {
        setTextAppearance(R.style.Body)
    }
}

class BodyS @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    init {
        setTextAppearance(R.style.BodyS)
    }
}