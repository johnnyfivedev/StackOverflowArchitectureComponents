package com.johnnyfivedev.data.datasource

import android.arch.lifecycle.LiveData
import com.johnnyfivedev.data.model.network.question.QuestionsResponse
import retrofit2.http.GET

interface QuestionsApi {

    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions(): LiveData<QuestionsResponse>
}
