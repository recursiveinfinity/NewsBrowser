package com.example.newsbrowser

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.newsbrowser.di.ApplicationModule
import com.example.newsbrowser.di.DaggerAppComponent
import com.example.newsbrowser.ui.home.HomeViewModel
import com.example.newsbrowser.ui.home.HomeViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(application))
            .build()
            .inject(this)

        val homeViewModel = ViewModelProviders.of(this, homeViewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.getArticles(application)
    }
}
