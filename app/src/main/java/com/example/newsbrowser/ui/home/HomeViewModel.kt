package com.example.newsbrowser.ui.home

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.newsbrowser.API_KEY
import com.example.newsbrowser.Article
import com.example.newsbrowser.NEWS_SOURCE
import com.example.newsbrowser.data.DataSource
import com.example.newsbrowser.data.LocalDataSource
import com.example.newsbrowser.data.NewsRepository
import com.example.newsbrowser.data.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {
    private val articlesObservable: MutableLiveData<List<Article>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getArticlesObservable():LiveData<List<Article>> = articlesObservable

    private lateinit var repository: DataSource


    fun getArticles(application: Application) {
        repository = NewsRepository(remoteDataSource = RemoteDataSource(),
            localDataSource = LocalDataSource(application))
        compositeDisposable.add(repository.getTopNewsHeadlines(NEWS_SOURCE, API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ Log.d("News Description: ", it[0].description)}, {
                it.printStackTrace()
            }))
    }
}