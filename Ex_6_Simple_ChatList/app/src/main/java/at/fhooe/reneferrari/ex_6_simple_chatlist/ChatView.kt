package at.fhooe.reneferrari.ex_6_simple_chatlist

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.card.MaterialCardView

class ChatView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : MaterialCardView(context, attrs) {

    init {
        View.inflate(context, R.layout.view_chatview, this)

        strokeWidth = 0
        setCardBackgroundColor(context.getColor(R.color.white))

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ChatView,
            0, 0
        ).apply {

            try {
                val contactName = getText(R.styleable.ChatView_contact_name)
                val message = getText(R.styleable.ChatView_message)
                val time = getText(R.styleable.ChatView_time)
                val avatar = getResourceId(R.styleable.ChatView_avatar, 0)

                findViewById<TextView>(R.id.tv_chatview_contact).text = contactName
                findViewById<TextView>(R.id.tv_chatview_message).text = message
                findViewById<TextView>(R.id.tv_chatview_time).text = time
                findViewById<ImageView>(R.id.iv_chatview_avatar).setImageResource(avatar)

            } finally {
                recycle()
            }
        }

    }
}
