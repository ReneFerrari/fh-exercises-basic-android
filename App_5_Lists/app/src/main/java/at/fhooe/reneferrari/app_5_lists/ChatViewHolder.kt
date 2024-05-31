package at.fhooe.reneferrari.app_5_lists

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val civAvatar: CircleImageView = view.findViewById(R.id.civ_vhchat)
    private val tvName: TextView = view.findViewById(R.id.tv_vhchat_name)
    private val tvLastMessage: TextView = view.findViewById(R.id.tv_vhchat_lastmessage)
    private val tvTimeOfLastMessage: TextView = view.findViewById(R.id.tv_vhchat_time)

    fun bind(entry: ChatEntry) = with(entry) {
        civAvatar.setImageDrawable(ColorDrawable(avatarColor))
        tvName.text = name
        tvLastMessage.text = lastMessage
        tvTimeOfLastMessage.text = timeOfLastMessage
    }
}

data class ChatEntry(
    val avatarColor: Int,
    val name: String,
    val lastMessage: String,
    val timeOfLastMessage: String
)


