package com.example.newsbrowser

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.newsbrowser.ui.home.HomeViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        homeViewModel.getArticles(application)
    }
}
