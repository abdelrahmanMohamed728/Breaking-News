package com.example.breakingnews.koin_di

import android.app.Application
import com.example.breakingnews.repo.room.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(viewModelsModule, repoModule))
        }
        AppDatabase.initDatabase(this)
    }
}