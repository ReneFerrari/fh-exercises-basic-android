package at.fhooe.reneferrari.app_4_relativelayout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.card.MaterialCardView

class ImageTextCard @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : MaterialCardView(context, attrs) {

    init {
        val sixteenDp = 16.dpToPx(context)

        strokeWidth = 0
        setCardBackgroundColor(context.getColor(R.color.white))
        setContentPadding(sixteenDp, sixteenDp, sixteenDp, sixteenDp)

        View.inflate(context, R.layout.view_imagetextcard, this)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ImageTextCard,
            0, 0).apply {

            try {
                val text = getText(R.styleable.ImageTextCard_cardText)
                val imageId = getResourceId(R.styleable.ImageTextCard_cardImage, 0)

                findViewById<ImageView>(R.id.iv_imagetextcard).setImageResource(imageId)
                findViewById<TextView>(R.id.tv_imagetextcard).text = text

            } finally {
                recycle()
            }
        }

    }
}

fun Int.dpToPx(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()



