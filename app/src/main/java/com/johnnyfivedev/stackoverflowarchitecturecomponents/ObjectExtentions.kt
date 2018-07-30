package com.johnnyfivedev.stackoverflowarchitecturecomponents

import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

fun Any?.logAsJson(tag: String = "logAsJson") {
    Log.d(tag, " ")
    Log.d(tag, " ")

    val result = ObjectMapper()
        .configure(SerializationFeature.INDENT_OUTPUT, true)
        .writeValueAsString(this)

    LimitlessLog.largeLogD(tag, result)
    Log.d(tag, " ")
    Log.d(tag, " ")
}

