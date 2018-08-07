package com.johnnyfivedev.stackoverflowarchitecturecomponents.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.johnnyfivedev.stackoverflowarchitecturecomponents.di.ViewModelKey
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.ViewModelFactory
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.questions.QuestionViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuestionViewModel::class)
    abstract fun bindQuestionViewModel(questionViewModel: QuestionViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}