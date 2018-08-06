package com.johnnyfivedev.stackoverflowarchitecturecomponents

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.johnnyfivedev.data.repository.question.QuestionRepository
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.tv_text as tvText


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var questionRepository: QuestionRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.applicationComponent.inject(this)
        setContentView(R.layout.activity_main)


        //questionRepository.getQuestions()

       /* val retrofit = Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
*/
       /* val retrofitService = retrofit.create(QuestionRepository::class.java)
        retrofitService.getQuestions().enqueue({
            it.body().logAsJson()
            val questions: List<Question> = it.body()!!.questions
            var i = 0
        }, {
            it.printStackTrace()
        })*/
    }
}