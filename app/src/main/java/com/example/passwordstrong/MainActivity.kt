package com.example.passwordstrong
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.passwordstrong.databinding.ActivityMainBinding
import com.example.passwordstrong.model.PasswordStrength
import com.example.passwordstrong.presenter.PasswordPresenter
import com.example.passwordstrong.view.PasswordView

class MainActivity : AppCompatActivity(), PasswordView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: PasswordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnCheck.setText("Salir!")
        presenter = PasswordPresenter(this)


        binding.etPassword.addTextChangedListener {
            val password = it.toString()
            presenter.onPasswordChanged(password)
        }

        binding.btnCheck.setOnClickListener {
           // val password = binding.etPassword.text.toString()
            //presenter.onPasswordChanged(password)
            finish()
        }
    }

    override fun updatePasswordStrength(strength: PasswordStrength) {
        if (binding.etPassword.text.isEmpty()) {
            binding.tvColor1.setBackgroundColor(Color.LTGRAY)
            binding.tvColor2.setBackgroundColor(Color.LTGRAY)
            binding.tvColor3.setBackgroundColor(Color.LTGRAY)
        } else {
            val strengthText = when (strength) {

                PasswordStrength.WEAK -> {
                    binding.tvColor1.setBackgroundColor(Color.RED)
                    binding.tvColor2.setBackgroundColor(Color.LTGRAY)
                    binding.tvColor3.setBackgroundColor(Color.LTGRAY)
                    "Débil"
                }
                PasswordStrength.MEDIUM -> {
                    binding.tvColor1.setBackgroundColor(Color.RED)
                    binding.tvColor2.setBackgroundColor(Color.YELLOW)
                    binding.tvColor3.setBackgroundColor(Color.LTGRAY)
                    "Mediana"
                }
                PasswordStrength.STRONG -> {
                    binding.tvColor1.setBackgroundColor(Color.RED)
                    binding.tvColor2.setBackgroundColor(Color.YELLOW)
                    binding.tvColor3.setBackgroundColor(Color.GREEN)
                    "Fuerte"
                }
            }

            binding.tvPasswordStrength.text = "Fortaleza de la contraseña: $strengthText"
        }
    }
}

