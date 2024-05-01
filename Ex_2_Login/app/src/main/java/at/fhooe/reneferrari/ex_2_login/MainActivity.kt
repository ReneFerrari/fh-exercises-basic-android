package at.fhooe.reneferrari.ex_2_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.et_activity_main_username)
        val etPassword = findViewById<EditText>(R.id.et_activity_main_password)
        val btnLogin = findViewById<Button>(R.id.btn_activity_main_login)

        val tvError = findViewById<TextView>(R.id.tv_activity_main_error)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            when {
                username.isBlank() -> {
                    tvError.visibility = View.VISIBLE
                    tvError.text = getString(R.string.error_username_empty)
                }

                password.isBlank() -> {
                    tvError.visibility = View.VISIBLE
                    tvError.text = getString(R.string.error_password_empty)
                }

                else -> tvError.visibility = View.GONE
            }
        }
    }
}