package at.fhooe.reneferrari.app_3_loginwithdashboard

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    fun validate(username: String, password: String) = when {
        username != ValidCredentials.USERNAME -> LoginState.ERROR_USERNAME_WRONG
        password != ValidCredentials.PASSWORD -> LoginState.ERROR_PASSWORD_WRONG
        else -> LoginState.SUCCESS
    }
}

enum class LoginState {
    ERROR_USERNAME_WRONG,
    ERROR_PASSWORD_WRONG,
    SUCCESS
}