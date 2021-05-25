package com.example.cleanneo.domain.model

data class LoginModel(
    val `data`: Data,
    val message: String,
    val status: Int,
    val user_msg: String
)