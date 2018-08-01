package com.johnnyfivedev.stackoverflowarchitecturecomponents.di.module

import com.johnnyfivedev.data.datasource.QuestionsApi
import com.johnnyfivedev.data.network.ApiFactory
import com.johnnyfivedev.data.repository.question.QuestionRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    internal fun provideApiFactory() = ApiFactory()

    @Singleton
    @Provides
    fun provideQuestionsRepository(questionApi: QuestionsApi) = QuestionRepository(questionApi)

}