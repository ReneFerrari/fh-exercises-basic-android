package at.fhooe.reneferrari.ex_7_simple_notetaking

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val tvNote = view.findViewById<TextView>(R.id.tv_note_note)

    fun bind(text: String, onNoteClicked: (String) -> Unit) {
        tvNote.text = text

        view.setOnClickListener {
            onNoteClicked(text)
        }
    }
}