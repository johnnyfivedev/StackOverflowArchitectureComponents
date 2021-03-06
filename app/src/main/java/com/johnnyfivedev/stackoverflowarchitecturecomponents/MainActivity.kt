package com.johnnyfivedev.stackoverflowarchitecturecomponents

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.johnnyfivedev.data.Resource
import com.johnnyfivedev.data.model.network.question.Question
import com.johnnyfivedev.data.repository.question.QuestionRepository
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.activity.BaseActivity
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.adapter.QuestionsAdapter
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.questions.QuestionViewModel
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.widget.gone
import com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.widget.visible
import kotlinx.android.synthetic.main.activity_main.rv_questions
import kotlinx.android.synthetic.main.activity_main.shadow_preloader
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var questionRepository: QuestionRepository

    // todo create module for questions dependencies
    @Inject
    lateinit var questionsAdapter: QuestionsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.applicationComponent.inject(this)
        setContentView(R.layout.activity_main)

        val questionViewModel: QuestionViewModel = getViewModel(viewModelFactory)
        observe(questionViewModel.questions, this::onQuestionsChanged)

        initUI()
    }

    private fun onQuestionsChanged(resource: Resource<List<Question>>) {
        when (resource) {
            is Resource.Loading -> {
                shadow_preloader.visible()
            }
            is Resource.Data -> {
                shadow_preloader.gone()
                questionsAdapter.swapItems(resource.data)
            }
        }
    }

    private fun initUI() {
        rv_questions.layoutManager = LinearLayoutManager(this)
        rv_questions.adapter = questionsAdapter
    }
}