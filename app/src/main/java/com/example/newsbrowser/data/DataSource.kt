package com.example.newsbrowser.data

import com.example.newsbrowser.Article
import io.reactivex.Maybe

interface DataSource {
    fun getTopNewsHeadlines(source: String, apiKey: String): Maybe<List<Article>>
    fun addNewsHeadline(article: Article)
}