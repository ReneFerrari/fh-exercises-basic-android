package at.fhooe.reneferrari.app_5_lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chatEntries: List<ChatEntry>) : RecyclerView.Adapter<ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.vh_chat, //layout
                parent, //root
                false //attachToRoot
            )
        )
    }

    override fun getItemCount(): Int = chatEntries.count()

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(entry = chatEntries[position])
    }
}

