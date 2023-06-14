package com.example.mycomposeapp.core.data.remote.source

import com.example.mycomposeapp.core.data.model.LoginBody
import com.example.mycomposeapp.core.data.model.LoginResponse
import com.example.mycomposeapp.core.data.remote.api.AuthService
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val authService: AuthService):AuthRemoteDataSource {
    override suspend fun login(username: String, password: String): Result<LoginResponse> {
      return kotlin.runCatching {
          authService.login(LoginBody(username,password))
      }
    }
}