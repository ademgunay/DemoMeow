package com.gunaya.demo.demomeow.application

import android.app.Application
import com.gunaya.demo.demomeow.module.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DemoMeowApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Adding Koin modules to our application
        startKoin {
            androidContext(this@DemoMeowApplication)
            modules(appModules)
        }
    }
}