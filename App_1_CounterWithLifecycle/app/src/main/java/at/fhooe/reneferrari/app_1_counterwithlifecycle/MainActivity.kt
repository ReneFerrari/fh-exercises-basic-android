package at.fhooe.reneferrari.app_1_counterwithlifecycle

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val btnIncrement = findViewById<Button>(R.id.btn_activity_main_increment)
        val tvCount = findViewById<TextView>(R.id.tv_activity_main_count)

        tvCount.text = viewModel.currentCount.toString()

        btnIncrement.setOnClickListener {
            viewModel.currentCount++
            tvCount.text = viewModel.currentCount.toString()
        }
    }
}

