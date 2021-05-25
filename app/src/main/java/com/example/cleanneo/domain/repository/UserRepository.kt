package com.example.cleanneo.domain.repository

interface UserRepository {

    fun logIn(email:String,password: String)

}