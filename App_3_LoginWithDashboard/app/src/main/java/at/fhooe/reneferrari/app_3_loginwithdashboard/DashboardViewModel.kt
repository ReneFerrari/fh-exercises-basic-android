package at.fhooe.reneferrari.app_3_loginwithdashboard

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Locale

class DashboardViewModel: ViewModel() {
    private val dateFormat = SimpleDateFormat("dd.MM.yyyy hh:mm:ss", Locale.getDefault())

    val loginTimeString: String = dateFormat.format(System.currentTimeMillis())
}