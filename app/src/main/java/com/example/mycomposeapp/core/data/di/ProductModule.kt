package com.example.mycomposeapp.core.data.di

import com.example.mycomposeapp.core.data.remote.repository.ProductRepository
import com.example.mycomposeapp.core.data.remote.repository.ProductRepositoryImpl
import com.example.mycomposeapp.core.data.remote.source.ProductRemoteDataImpl
import com.example.mycomposeapp.core.data.remote.source.ProductRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface ProductModule {
    @Binds
    fun bindProductRemoteDataSource(
        sourceImpl: ProductRemoteDataImpl
    ): ProductRemoteDataSource

    @Binds
    fun bindProductRepository(
        sourceImpl: ProductRepositoryImpl
    ): ProductRepository

}