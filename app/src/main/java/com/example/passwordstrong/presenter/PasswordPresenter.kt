package com.example.passwordstrong.presenter



import com.example.passwordstrong.model.PasswordChecker
import com.example.passwordstrong.model.PasswordStrength
import com.example.passwordstrong.view.PasswordView

class PasswordPresenter(private val view: PasswordView) {

    private val passwordChecker = PasswordChecker()

    fun onPasswordChanged(password: String) {
        val strength = passwordChecker.checkPasswordStrength(password)
        view.updatePasswordStrength(strength)
    }
}
