package com.johnnyfivedev.data.converter

import com.johnnyfivedev.data.model.db.QuestionEntity
import com.johnnyfivedev.data.model.network.question.Question
import com.johnnyfivedev.data.model.network.question.QuestionsResponse

object QuestionMapper {

    fun toDb(source: Question): QuestionEntity {
        return QuestionEntity(
            id = source.id,
            title = source.title
        )
    }

    fun toDb(source: List<Question>): MutableList<QuestionEntity> {
        val questionEntities = mutableListOf<QuestionEntity>()
        for (question in source) {
            questionEntities.add(toDb(question))
        }
        return questionEntities
    }

    fun fromDb(source: QuestionEntity): Question {
        return Question(
            id = source.id,
            title = source.title
        )
    }

    fun fromDb(source: List<QuestionEntity>): List<Question> {
        val questions = mutableListOf<Question>()
        for (questionEntity in source) {
            questions.add(fromDb(questionEntity))
        }
        return questions
    }
}