package com.example.newsbrowser.data

import com.example.newsbrowser.Article
import com.example.newsbrowser.net.NewsService
import io.reactivex.Maybe

class RemoteDataSource(private val newsService: NewsService) : DataSource {

    override fun getTopNewsHeadlines(source: String, apiKey: String): Maybe<List<Article>> {
        return newsService.getTopHeadlines(source, apiKey)
            .flatMapMaybe { Maybe.just(it.articles) }
    }

    override fun addNewsHeadline(article: Article) {
        //NO-OP
    }

}