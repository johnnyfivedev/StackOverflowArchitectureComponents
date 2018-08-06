package com.johnnyfivedev.stackoverflowarchitecturecomponents

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        return DaggerAppComponent
            .builder()
            .context(this)
            .build()
    }
}