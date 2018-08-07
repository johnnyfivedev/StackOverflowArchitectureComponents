package com.johnnyfivedev.stackoverflowarchitecturecomponents

import android.os.Bundle
import com.johnnyfivedev.data.Resource
import com.johnnyfivedev.data.model.network.question.Question
import com.johnnyfivedev.data.repository.question.QuestionRepository
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.activity.BaseActivity
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.questions.QuestionViewModel
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.tv_text as tvText


class MainActivity : BaseActivity() {

    @Inject
    lateinit var questionRepository: QuestionRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.applicationComponent.inject(this)
        setContentView(R.layout.activity_main)

        val questionViewModel: QuestionViewModel = getViewModel(viewModelFactory)
        observe(questionViewModel.questions, this::onQuestionsChanged)


        //questionRepository.getQuestions()

        /* val retrofit = Retrofit.Builder()
             .baseUrl("https://api.stackexchange.com/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()*/

        /* val retrofitService = retrofit.create(QuestionRepository::class.java)
         retrofitService.getQuestions().enqueue({
             it.body().logAsJson()
             val questions: List<Question> = it.body()!!.questions
             var i = 0
         }, {
             it.printStackTrace()
         })*/
    }

    private fun onQuestionsChanged(resource: Resource<List<Question>>) {
        when (resource) {
            is Resource.Loading -> showMessage("loading")
            //is Resource.Data -> showMessage("QWE!")
            //is Resource.Data -> updateUserData(resource.data)
            is Resource.Data -> resource.data
        }
    }
}