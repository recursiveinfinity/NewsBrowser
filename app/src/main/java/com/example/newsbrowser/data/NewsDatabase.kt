package com.example.newsbrowser.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.newsbrowser.Article
import com.example.newsbrowser.DATABASE_VERSION

@Database(entities = [Article::class], version = DATABASE_VERSION)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsArticlesDao(): NewsArticlesDao
}