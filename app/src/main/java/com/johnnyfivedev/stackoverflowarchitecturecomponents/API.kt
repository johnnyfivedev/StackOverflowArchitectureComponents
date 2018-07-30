package com.johnnyfivedev.stackoverflowarchitecturecomponents

import retrofit2.Call
import retrofit2.http.GET

interface API {

    //@GET("2.2/questions")
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    //fun getQuestions(): Call<List<Question>>
    fun getQuestions(): Call<Any>
}