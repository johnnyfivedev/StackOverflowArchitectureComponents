package com.johnnyfivedev.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    fun <T> create(clazz: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(clazz)
    }
}