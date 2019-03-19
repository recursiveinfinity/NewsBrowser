package com.example.newsbrowser.di

import android.app.Application
import com.example.newsbrowser.data.DataSource
import com.example.newsbrowser.data.NewsRepository
import com.example.newsbrowser.ui.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext() = application

    @Provides
    @Repository
    @Singleton
    fun provideNewsRepository(
        @Local localDataSource: DataSource,
        @Remote remoteDataSource: DataSource
    ): DataSource {
        return NewsRepository(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideHomeViewModelFactory(@Repository repository: DataSource): HomeViewModelFactory {
        return HomeViewModelFactory(repository)
    }

}