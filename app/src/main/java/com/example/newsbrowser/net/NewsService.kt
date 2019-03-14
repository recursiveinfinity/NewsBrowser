package com.example.newsbrowser.net

import com.example.newsbrowser.NewsItem
import com.example.newsbrowser.TOP_HEADLINES_ENDPOINT
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET(TOP_HEADLINES_ENDPOINT)
    fun getTopHeadlines(@Query("sources") source: String,
                        @Query("apiKey") apiKey: String): Single<NewsItem>
}