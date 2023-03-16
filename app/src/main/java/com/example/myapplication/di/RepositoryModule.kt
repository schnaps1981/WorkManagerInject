package com.example.myapplication.di

import com.example.myapplication.repository.SampleRepository
import com.example.myapplication.repository.SampleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindRepository(repository: SampleRepositoryImpl): SampleRepository
}
