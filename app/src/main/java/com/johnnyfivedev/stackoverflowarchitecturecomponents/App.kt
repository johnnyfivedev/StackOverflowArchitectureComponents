package com.johnnyfivedev.stackoverflowarchitecturecomponents

import android.app.Application
import com.johnnyfivedev.stackoverflowarchitecturecomponents.di.component.ApplicationComponent
import com.johnnyfivedev.stackoverflowarchitecturecomponents.di.component.DaggerApplicationComponent

class App : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .context(this)
            .build()
    }
}