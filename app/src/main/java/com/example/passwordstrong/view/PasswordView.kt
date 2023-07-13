package com.example.passwordstrong.view



import com.example.passwordstrong.model.PasswordStrength

interface PasswordView {
    fun updatePasswordStrength(strength: PasswordStrength)
}
