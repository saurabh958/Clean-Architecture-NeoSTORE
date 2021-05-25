package com.example.cleanneo.domain.usecase


import com.example.cleanneo.domain.repository.UserRepository

class LoginUseCase(private val userRepository: UserRepository)
{
    //operator fun invoke() = userRepository.logIn()
}