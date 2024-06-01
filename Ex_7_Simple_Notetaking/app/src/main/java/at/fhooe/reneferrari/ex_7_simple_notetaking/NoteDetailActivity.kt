package at.fhooe.reneferrari.ex_7_simple_notetaking

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NoteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        intent.extras?.getString(KEY_NOTE).let { note ->
            findViewById<TextView>(R.id.tv_activitynotedetail_note).text = note
        }
    }

    companion object {
        const val KEY_NOTE = "key_note"
    }
}