package com.example.newsbrowser

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.newsbrowser.databinding.ActivityMainBinding
import com.example.newsbrowser.di.ApplicationModule
import com.example.newsbrowser.di.DaggerAppComponent
import com.example.newsbrowser.ui.home.HomeViewModel
import com.example.newsbrowser.ui.home.HomeViewModelFactory
import com.example.newsbrowser.ui.home.NewsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(application))
            .build()
            .inject(this)

        val homeViewModel = ViewModelProviders.of(this, homeViewModelFactory).get(HomeViewModel::class.java)
        activityMainBinding.progressVisibility = homeViewModel.getProgressObservable()


        val newsAdapter = NewsAdapter()
        rvNewsItems.layoutManager = LinearLayoutManager(this)
        rvNewsItems.adapter = newsAdapter

        homeViewModel.getArticlesObservable().observe(this, Observer { newsAdapter.setData(it) })
        homeViewModel.getArticles()

    }
}
