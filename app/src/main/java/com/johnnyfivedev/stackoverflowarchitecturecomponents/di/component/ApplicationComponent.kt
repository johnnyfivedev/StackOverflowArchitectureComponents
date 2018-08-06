package com.johnnyfivedev.stackoverflowarchitecturecomponents.di.component

import android.content.Context
import com.johnnyfivedev.stackoverflowarchitecturecomponents.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    //fun userComponent(): UserComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(appContext: Context): Builder

        fun build(): ApplicationComponent
    }
}