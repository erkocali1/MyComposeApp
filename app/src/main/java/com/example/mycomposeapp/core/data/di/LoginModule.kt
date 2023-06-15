package com.example.mycomposeapp.core.data.di

import com.example.mycomposeapp.core.data.remote.repository.AuthRepository
import com.example.mycomposeapp.core.data.remote.repository.AuthRepositoryImpl
import com.example.mycomposeapp.core.data.remote.source.AuthRemoteDataSource
import com.example.mycomposeapp.core.data.remote.source.AuthRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginModule {
    @Binds
    fun bindsLoginRemoteService(
        sourceIml:AuthRemoteDataSourceImpl):AuthRemoteDataSource

    @Binds
    fun bindLoginRepository(
        repositoryImpl: AuthRepositoryImpl
    ):AuthRepository
}