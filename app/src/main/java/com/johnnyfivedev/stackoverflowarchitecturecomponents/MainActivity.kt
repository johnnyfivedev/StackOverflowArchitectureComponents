package com.johnnyfivedev.stackoverflowarchitecturecomponents

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlinx.android.synthetic.main.activity_main.tv_text as tvText


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(API::class.java)
        retrofitService.getQuestions().enqueue({
            it.body().logAsJson()
        }, {
            it.printStackTrace()
        })
    }
}