package com.example.sewamobil.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.sewamobil.databinding.ActivityLoginBinding
import com.example.sewamobil.ui.auth.model.UserLogin

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val user = UserLogin(
                email = binding.etEmail.text.toString().trim(),
                password = binding.etPassword.text.toString()
            )

            if (validateInput(user)) {
                // logic
            }
        }

        binding.tvGoToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun validateInput(user: UserLogin): Boolean {
        var isValid = true

        binding.etEmail.error = null
        binding.etPassword.error = null

        if (user.email.isEmpty()) {
            binding.etEmail.error = "Email is required"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(user.email).matches()) {
            binding.etEmail.error = "Invalid email format"
            isValid = false
        }

        if (user.password.isEmpty()) {
            binding.etPassword.error = "Password is required"
            isValid = false
        }

        return isValid
    }
}
