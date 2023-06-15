package com.example.mycomposeapp.core.data.remote.repository

import com.example.mycomposeapp.core.data.model.LoginResponse
import com.example.mycomposeapp.core.data.remote.source.AuthRemoteDataSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource:AuthRemoteDataSource
):AuthRepository {
    override suspend fun login(username: String, password: String): Result<LoginResponse> {
        return authRemoteDataSource.login(username,password)
    }
}