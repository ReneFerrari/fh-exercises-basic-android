package at.fhooe.reneferrari.app_3_loginwithdashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val btnLogin = findViewById<Button>(R.id.btn_activity_login_login)
        val etUsername = findViewById<EditText>(R.id.et_activity_login_username)
        val etPassword = findViewById<EditText>(R.id.et_activity_login_password)
        val tvError = findViewById<TextView>(R.id.tv_activity_login_error)

        etUsername.doAfterTextChanged { tvError.isVisible = false }
        etPassword.doAfterTextChanged { tvError.isVisible = false }

        btnLogin.setOnClickListener {
            val loginState = viewModel.validate(
                username = etUsername.text.toString(),
                password = etPassword.text.toString()
            )

            tvError.isVisible = loginState != LoginState.SUCCESS

            when (loginState) {
                LoginState.ERROR_USERNAME_WRONG -> {
                    tvError.text = getString(R.string.error_username_wrong)
                }
                LoginState.ERROR_PASSWORD_WRONG -> {
                    tvError.text = getString(R.string.error_password_wrong)
                }
                LoginState.SUCCESS -> showDashboard(etUsername.text.toString())
            }
        }
    }

    private fun showDashboard(username: String) {
        val intent = Intent(this, DashboardActivity::class.java)
        val bundle = Bundle()

        bundle.putString(KEY_USERNAME, username)
        intent.putExtras(bundle)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

        startActivity(intent)
    }

    companion object {
        const val KEY_USERNAME = "Username"
    }
}