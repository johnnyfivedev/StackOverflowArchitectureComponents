package com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.questions

import android.arch.lifecycle.MutableLiveData
import com.johnnyfivedev.data.Resource
import com.johnnyfivedev.data.model.network.question.Question
import com.johnnyfivedev.data.repository.question.QuestionRepository
import com.johnnyfivedev.stackoverflowarchitecturecomponents.onNext
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.BaseViewModel
import javax.inject.Inject

class QuestionViewModel @Inject constructor(private val questionRepository: QuestionRepository) : BaseViewModel() {

    val questions: MutableLiveData<Resource<List<Question>>> = MutableLiveData()

    init {
        getQuestions()
    }

    private fun getQuestions() {
        safeSubscribe {
            questionRepository.getQuestions()
                .subscribe(
                    { questions.onNext(it) },
                    {
                        it.printStackTrace()
                    }
                )
        }
    }
}