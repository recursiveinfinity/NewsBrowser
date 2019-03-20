package com.example.newsbrowser.data

import com.example.newsbrowser.Article
import io.reactivex.Maybe

class NewsRepository(private val localDataSource: DataSource,
                     private val remoteDataSource: DataSource) : DataSource {


    override fun getTopNewsHeadlines(source: String, apiKey: String): Maybe<List<Article>> {
        return remoteDataSource.getTopNewsHeadlines(source, apiKey)
            //.doOnSuccess { result -> result.forEach { article -> addNewsHeadline(article) } }
            /*.onErrorResumeNext { _: Throwable ->
                localDataSource.getTopNewsHeadlines(source, apiKey) }*/
    }

    override fun addNewsHeadline(article: Article) {
        localDataSource.addNewsHeadline(article)
    }

}