package com.example.newsbrowser.data

import com.example.newsbrowser.Article

class LocalDataSource(private val database: NewsDatabase) : DataSource {

    override fun addNewsHeadline(article: Article) {
        database.newsArticlesDao().addArticle(article)
    }

    override fun getTopNewsHeadlines(source: String, apiKey: String) = database.newsArticlesDao().getAllArticles()

}