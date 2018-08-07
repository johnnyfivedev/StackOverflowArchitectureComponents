package com.johnnyfivedev.stackoverflowarchitecturecomponents.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.johnnyfivedev.core.provider.SchedulersProvider
import com.johnnyfivedev.core.provider.SystemInfoProvider
import com.johnnyfivedev.data.dao.QuestionDao
import com.johnnyfivedev.data.network.ApiFactory
import com.johnnyfivedev.data.network.QuestionApi
import com.johnnyfivedev.data.repository.question.QuestionRepository
import com.johnnyfivedev.data.repository.question.QuestionRepositoryImpl
import com.johnnyfivedev.stackoverflowarchitecturecomponents.provider.SchedulersProviderImpl
import com.johnnyfivedev.stackoverflowarchitecturecomponents.provider.SystemInfoProviderImpl
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.adapter.QuestionsAdapter
import dagger.Module
import dagger.Provides
import rmr.arch.sample.data.storage.db.AppDatabase
import rmr.arch.sample.data.storage.db.AppDatabaseImpl
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    @Provides
    @Singleton
    internal fun provideApiFactory() = ApiFactory()

    @Provides
    @Singleton
    internal fun provideQuestionApi(apiFactory: ApiFactory) = apiFactory.create(QuestionApi::class.java)

    @Provides
    @Singleton
    internal fun provideSchedulersProvider(): SchedulersProvider = SchedulersProviderImpl()

    @Provides
    @Singleton
    internal fun provideSystemInfoProvider(context: Context): SystemInfoProvider = SystemInfoProviderImpl(context)

    @Provides
    @Singleton
    internal fun provideAppDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabaseImpl::class.java, AppDatabaseImpl.NAME).build()
    }

    @Provides
    @Singleton
    internal fun provideQuestionDao(appDatabase: AppDatabase) = appDatabase.getQuestionDao()

    @Provides
    @Singleton
    fun provideQuestionRepository(
        schedulersProvider: SchedulersProvider,
        systemInfoProvider: SystemInfoProvider,
        questionApi: QuestionApi,
        questionDao: QuestionDao
    ): QuestionRepository = QuestionRepositoryImpl(
        schedulersProvider,
        systemInfoProvider,
        questionApi,
        questionDao
    )

    @Provides
    @Singleton
    fun provideQuestionAdapter(context: Context) = QuestionsAdapter(context)

}