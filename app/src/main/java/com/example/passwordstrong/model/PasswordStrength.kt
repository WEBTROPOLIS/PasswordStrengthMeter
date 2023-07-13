package com.example.passwordstrong.model



enum class PasswordStrength {
    WEAK, MEDIUM, STRONG
}

class PasswordChecker {

    fun checkPasswordStrength(password: String): PasswordStrength {
        return when {
            password.length < 5 -> PasswordStrength.WEAK
            !password.contains(Regex("[A-Z]")) -> PasswordStrength.MEDIUM
            else -> PasswordStrength.STRONG
        }
    }
}
