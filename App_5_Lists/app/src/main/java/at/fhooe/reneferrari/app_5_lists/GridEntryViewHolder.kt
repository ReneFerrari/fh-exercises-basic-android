package at.fhooe.reneferrari.app_5_lists

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GridEntryViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvText = view.findViewById<TextView>(R.id.tv_vhgridentry_text)

    fun bind(text: String, onItemClick: (String) -> Unit) {
        tvText.text = text
        itemView.setOnClickListener { onItemClick(text) }
    }
}

