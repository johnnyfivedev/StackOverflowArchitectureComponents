package com.johnnyfivedev.data.model.network.question

import com.google.gson.annotations.SerializedName

data class QuestionsResponse(

    @SerializedName("items")
    val questions: List<Question>
)