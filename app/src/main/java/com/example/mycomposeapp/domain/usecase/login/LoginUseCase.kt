package com.example.mycomposeapp.domain.usecase.login

import com.example.mycomposeapp.core.data.model.LoginResponse
import com.example.mycomposeapp.core.data.remote.repository.AuthRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(username: String, password: String): Flow<LoginResponse> {
        return flow {
            val result = authRepository.login(username, password)
            (result.getOrNull() ?: throw IllegalArgumentException("error message")).also {
                emit(it)
            }
        }
    }
}