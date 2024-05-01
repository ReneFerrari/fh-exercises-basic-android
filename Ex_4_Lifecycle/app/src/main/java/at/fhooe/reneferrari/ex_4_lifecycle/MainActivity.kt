package at.fhooe.reneferrari.ex_4_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("onCreate")
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        log("onStart")
    }

    override fun onPause() {
        super.onPause()
        log("onPause")
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    override fun onRestart() {
        super.onRestart()
        log("onRestart")
    }

    override fun onStop() {
        super.onStop()
        log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
    }

    private fun log(message: String) {
        Log.d("LIFECYCLE", message)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}