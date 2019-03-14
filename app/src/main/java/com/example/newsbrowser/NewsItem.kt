package com.example.newsbrowser

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

data class NewsItem(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

@Entity(tableName = TABLE_NAME)
data class Article(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)


data class Source(
    val id: String,
    val name: String
)