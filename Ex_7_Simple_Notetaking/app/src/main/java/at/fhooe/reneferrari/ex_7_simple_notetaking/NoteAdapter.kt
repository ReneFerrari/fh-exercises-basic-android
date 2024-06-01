package at.fhooe.reneferrari.ex_7_simple_notetaking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(val notes: List<String>, val onNoteClicked: (String) -> Unit) : RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_note,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = notes.count()

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position], onNoteClicked)
    }
}