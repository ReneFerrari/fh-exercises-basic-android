package at.fhooe.reneferrari.app_3_loginwithdashboard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class DashboardActivity: AppCompatActivity() {

    private lateinit var viewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

        val tvGreeting = findViewById<TextView>(R.id.tv_activity_dashboard_greeting)
        val tvLastLoginTime = findViewById<TextView>(R.id.tv_activity_dashboard_lastlogintime)

        tvGreeting.text = getString(R.string.dashboard_greeting, intent.extras?.getString(LoginActivity.KEY_USERNAME))
        tvLastLoginTime.text = getString(R.string.dashboard_lastloggedin, viewModel.loginTimeString)
    }
}