package com.example.sewamobil.ui.auth

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.sewamobil.databinding.ActivityRegisterBinding
import com.example.sewamobil.ui.auth.model.UserRegister

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val user = UserRegister(
                name = binding.etName.text.toString().trim(),
                email = binding.etEmail.text.toString().trim(),
                password = binding.etPassword.text.toString(),
                confirmPassword = binding.etConfirmPassword.text.toString()
            )

            if (validateInput(user)) {
                // Proceed with registration or API call
            }
        }

        binding.tvGoToLogin.setOnClickListener {
            finish()
        }
    }

    private fun validateInput(user: UserRegister): Boolean {
        var isValid = true

        binding.etName.error = null
        binding.etEmail.error = null
        binding.etPassword.error = null
        binding.etConfirmPassword.error = null

        if (user.name.isEmpty()) {
            binding.etName.error = "Full name is required"
            isValid = false
        }

        if (user.email.isEmpty()) {
            binding.etEmail.error = "Email is required"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(user.email).matches()) {
            binding.etEmail.error = "Invalid email format"
            isValid = false
        }

        if (user.password.length < 6) {
            binding.etPassword.error = "Password must be at least 6 characters"
            isValid = false
        }

        if (user.password != user.confirmPassword) {
            binding.etConfirmPassword.error = "Passwords do not match"
            isValid = false
        }

        return isValid
    }
}
