package com.skycore.practicaltest

import android.app.Application
import com.skycore.practicaltest.koin.mymodule
import com.skycore.practicaltest.koin.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare used Android context
            androidContext(this@MyApp)
            // declare modules

            modules(networkModule, mymodule)
        }
    }

}