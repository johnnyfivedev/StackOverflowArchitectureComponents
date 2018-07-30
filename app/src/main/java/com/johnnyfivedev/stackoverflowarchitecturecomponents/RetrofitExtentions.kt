package com.johnnyfivedev.stackoverflowarchitecturecomponents

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> Call<T>.enqueue(onSuccess: (Response<T>) -> Unit, onFailure: (throwable: Throwable) -> Unit) {
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>?, throwable: Throwable) {
            onFailure(throwable)
        }

        override fun onResponse(call: Call<T>?, response: Response<T>) {
            onSuccess(response)
        }
    })
}