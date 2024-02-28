package com.example.weatherforecast.di

import com.example.weatherforecast.data.DataProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModel {

    @Provides
    @Singleton
    fun provideRepository(): DataProvider {
        return DataProvider()
    }
}
