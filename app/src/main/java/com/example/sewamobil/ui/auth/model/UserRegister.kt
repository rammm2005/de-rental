package com.example.sewamobil.ui.auth.model

data class UserRegister(
    val name: String,
    val email: String,
    val password: String,
    val confirmPassword: String
)