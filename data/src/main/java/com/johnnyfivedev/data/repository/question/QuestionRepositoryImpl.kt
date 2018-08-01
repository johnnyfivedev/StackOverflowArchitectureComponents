package com.johnnyfivedev.data.repository.question

import com.johnnyfivedev.data.Resource
import com.johnnyfivedev.data.datasource.QuestionsApi
import com.johnnyfivedev.data.model.network.question.Question
import com.johnnyfivedev.data.model.network.question.QuestionsResponse
import com.johnnyfivedev.data.repository.NetworkBoundResource
import io.reactivex.Flowable

class QuestionRepositoryImpl constructor(
    private val questionsApi: QuestionsApi
) : QuestionRepository {

    override fun getQuestions(): Flowable<Resource<List<Question>>> {
        return object: NetworkBoundResource<List<Question>, QuestionsResponse>
    }
}