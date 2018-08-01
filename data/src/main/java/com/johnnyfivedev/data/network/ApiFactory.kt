package com.johnnyfivedev.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    fun <T> create(clazz: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(clazz)
    }
}