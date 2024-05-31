package at.fhooe.reneferrari.app_5_lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatMessagesAdapter(private val chatMessages: List<ChatMessage>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int = when (chatMessages[position].wasReceived) {
        true -> ChatMessageViewType.RECEIVED_MESSAGE.index
        false -> ChatMessageViewType.SENT_MESSAGE.index
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (ChatMessageViewType.entries.first { it.index == viewType }) {
            ChatMessageViewType.SENT_MESSAGE -> SentMessageViewHolder(
                inflater.inflate(R.layout.vh_sentmessage, parent, false)
            )

            ChatMessageViewType.RECEIVED_MESSAGE -> ReceivedMessageViewHolder(
                inflater.inflate(R.layout.vh_receivedmessage, parent, false)
            )
        }
    }

    override fun getItemCount(): Int = chatMessages.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SentMessageViewHolder -> holder.bind(chatMessages[position])
            is ReceivedMessageViewHolder -> holder.bind(chatMessages[position])
        }
    }
}

enum class ChatMessageViewType(val index: Int) {
    SENT_MESSAGE(index = 0),
    RECEIVED_MESSAGE(index = 1)
}

data class ChatMessage(
    val message: String,
    val time: String,
    val wasReceived: Boolean
)