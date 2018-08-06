package com.johnnyfivedev.data.model.network.question

import com.google.gson.annotations.SerializedName

data class Question(

    @SerializedName("question_id")
    val id: Long,

    var title: String
)