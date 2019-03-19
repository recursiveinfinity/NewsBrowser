package com.example.newsbrowser.di

import com.example.newsbrowser.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, NetworkModule::class, DatabaseModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}