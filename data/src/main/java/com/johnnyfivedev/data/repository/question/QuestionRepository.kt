package com.johnnyfivedev.data.repository.question

import com.johnnyfivedev.data.Resource
import com.johnnyfivedev.data.model.network.question.Question
import io.reactivex.Flowable

interface QuestionRepository {

    fun getQuestions(): Flowable<Resource<List<Question>>>
}