package com.example.newsbrowser.data

import android.arch.persistence.room.*
import com.example.newsbrowser.Article
import io.reactivex.Maybe

@Dao
interface NewsArticlesDao {
    @Query("SELECT * FROM articles")
    fun getAllArticles(): Maybe<List<Article>>

    @Insert
    fun addArticle(article: Article)

    @Update
    fun updateArticle(article: Article)

    @Delete
    fun deleteArticle(article: Article)

}