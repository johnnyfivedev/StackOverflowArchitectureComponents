package com.johnnyfivedev.data.network

import com.johnnyfivedev.data.model.network.question.QuestionsResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface QuestionApi {

    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions(): Flowable<QuestionsResponse>
}
