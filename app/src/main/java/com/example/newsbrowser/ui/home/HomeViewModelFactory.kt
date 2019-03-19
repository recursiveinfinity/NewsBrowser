package com.example.newsbrowser.ui.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.newsbrowser.data.DataSource
import java.lang.IllegalArgumentException

class HomeViewModelFactory(private val repository: DataSource) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unsupported Class")
    }

}