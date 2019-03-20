package com.example.newsbrowser.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.util.Log
import com.example.newsbrowser.API_KEY
import com.example.newsbrowser.Article
import com.example.newsbrowser.NEWS_SOURCE
import com.example.newsbrowser.data.DataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val repository: DataSource) : ViewModel() {
    private val articlesObservable: MutableLiveData<List<Article>> = MutableLiveData()
    private val progressObservable = ObservableBoolean(false)
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getArticlesObservable(): LiveData<List<Article>> = articlesObservable
    fun getProgressObservable() = progressObservable

    fun getArticles() {
        compositeDisposable.add(repository.getTopNewsHeadlines(NEWS_SOURCE, API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progressObservable.set(true) }
            .doOnEvent { _, _ -> progressObservable.set(false) }
            .subscribe({ articlesObservable.value = it }, { it.printStackTrace() })
        )
    }
}