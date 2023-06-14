package com.example.mycomposeapp.core.data.remote.source

import com.example.mycomposeapp.core.data.model.LoginResponse

interface AuthRemoteDataSource {
    suspend fun login(username:String,password:String):Result<LoginResponse>
}