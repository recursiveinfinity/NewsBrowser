package com.example.newsbrowser.di

import android.app.Application
import android.arch.persistence.room.Room
import com.example.newsbrowser.DATABASE_NAME
import com.example.newsbrowser.data.DataSource
import com.example.newsbrowser.data.LocalDataSource
import com.example.newsbrowser.data.NewsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideNewsDatabase(application: Application): NewsDatabase {
        return Room.databaseBuilder(application, NewsDatabase::class.java, DATABASE_NAME)
            .build()
    }

    @Provides
    @Local
    @Singleton
    fun provideLocalDataSource(newsDatabase: NewsDatabase): DataSource {
        return LocalDataSource(newsDatabase)
    }
}