package com.example.newsbrowser.data

import android.app.Application
import android.arch.persistence.room.Room
import com.example.newsbrowser.Article
import com.example.newsbrowser.DATABASE_NAME
import io.reactivex.Maybe

class LocalDataSource(private val application: Application) : DataSource {

    private val database: NewsDatabase by lazy {
        Room.databaseBuilder(application, NewsDatabase::class.java, DATABASE_NAME)
            .build()
    }


    override fun addNewsHeadline(article: Article) {
        database.newsArticlesDao().addArticle(article)
    }

    override fun getTopNewsHeadlines(source: String, apiKey: String)
            = database.newsArticlesDao().getAllArticles()

}