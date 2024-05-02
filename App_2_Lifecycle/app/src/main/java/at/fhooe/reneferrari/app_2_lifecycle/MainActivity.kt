package at.fhooe.reneferrari.app_2_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private var text: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etField = findViewById<EditText>(R.id.et_activity_main_field)
        val tvValue = findViewById<TextView>(R.id.tv_activity_main_value)

        etField.addTextChangedListener {
            text = it.toString()
            Log.d("STUFF", "CALLED")
            tvValue.text = text
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("STUFF", "PAUSE")
    }

    override fun onStop() {
        super.onStop()
        Log.d("STUFF", "STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        text = "ASdfasdf"
        Log.d("STUFF", "DESTROY")
    }
}