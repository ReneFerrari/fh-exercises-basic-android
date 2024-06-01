package at.fhooe.reneferrari.ex_7_simple_notetaking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val recyclerView = findViewById<RecyclerView>(R.id.rv_activitymain_notes)
        val adapter = NoteAdapter(
            notes = viewModel.notes,
            onNoteClicked = { note ->
                val intent = Intent(this, NoteDetailActivity::class.java)
                intent.putExtra(NoteDetailActivity.KEY_NOTE, note)

                startActivity(intent)
            }
        )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val etNewNote = findViewById<EditText>(R.id.et_activitymain_note)
        val btnAdd = findViewById<Button>(R.id.btn_activitymain_add)

        btnAdd.setOnClickListener {
            val newNote = etNewNote.text.toString()
            viewModel.notes.add(newNote)
            adapter.notifyItemInserted(viewModel.notes.count() - 1)
        }
    }
}