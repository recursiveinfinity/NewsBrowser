package com.example.newsbrowser.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsbrowser.Article
import com.example.newsbrowser.databinding.ItemArticleBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val articles = mutableListOf<Article>()

    fun setData(data: List<Article>?) {
        data?.let {
            articles.clear()
            articles.addAll(data)
            notifyDataSetChanged()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(ItemArticleBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(viewHolder: NewsViewHolder, position: Int) {
        viewHolder.bind(articles[position])
    }


    class NewsViewHolder(private val itemNewsBinding: ItemArticleBinding) :
        RecyclerView.ViewHolder(itemNewsBinding.root) {
        fun bind(article: Article) {
            itemNewsBinding.article = article
            itemNewsBinding.executePendingBindings()
        }
    }
}