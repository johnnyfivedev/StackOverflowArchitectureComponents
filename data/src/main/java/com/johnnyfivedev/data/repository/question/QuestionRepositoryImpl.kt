package com.johnnyfivedev.data.repository.question

import com.johnnyfivedev.core.provider.SchedulersProvider
import com.johnnyfivedev.core.provider.SystemInfoProvider
import com.johnnyfivedev.data.Resource
import com.johnnyfivedev.data.converter.QuestionMapper
import com.johnnyfivedev.data.dao.QuestionDao
import com.johnnyfivedev.data.network.QuestionsApi
import com.johnnyfivedev.data.model.network.question.Question
import com.johnnyfivedev.data.model.network.question.QuestionsResponse
import com.johnnyfivedev.data.repository.NetworkBoundResource
import io.reactivex.Flowable

class QuestionRepositoryImpl constructor(
    private val schedulersProvider: SchedulersProvider,
    private val systemInfoProvider: SystemInfoProvider,
    private val questionsApi: QuestionsApi,
    private val questionDao: QuestionDao
) : QuestionRepository {

    override fun getQuestions(): Flowable<Resource<List<Question>>> {
        return object : NetworkBoundResource<List<Question>, QuestionsResponse>(schedulersProvider, systemInfoProvider) {

            override fun createCall() = questionsApi.getQuestions()

            override fun processResponse(response: QuestionsResponse) = response.questions

            override fun saveCallResult(source: List<Question>) = questionDao.insert(QuestionMapper.toDb(source))

            override fun loadFromDb(): Flowable<List<Question>> = questionDao.load().map { QuestionMapper.fromDb(it) }

        }.result
    }
}