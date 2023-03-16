package com.example.myapplication.di

import com.example.myapplication.repository.SampleRepository
import com.example.myapplication.repository.SampleRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindRepository(repository: SampleRepositoryImpl) : SampleRepository
}
