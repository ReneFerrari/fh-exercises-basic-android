package at.fhooe.reneferrari.app_5_lists

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SentMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvMessage = view.findViewById<TextView>(R.id.tv_vhsentmessage_message)
    private val tvTime = view.findViewById<TextView>(R.id.tv_vhsentmessage_time)

    fun bind(chatMessage: ChatMessage) = with(chatMessage) {
        tvMessage.text = message
        tvTime.text = time
    }
}

