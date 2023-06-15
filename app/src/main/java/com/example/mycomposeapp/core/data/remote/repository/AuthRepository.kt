package com.example.mycomposeapp.core.data.remote.repository

import com.example.mycomposeapp.core.data.model.LoginResponse

interface AuthRepository {
    suspend fun login(username:String,password:String):Result<LoginResponse>

}