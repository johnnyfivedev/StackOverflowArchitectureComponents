package com.johnnyfivedev.data

sealed class Resource<out T> {
    class Data<out T>(val data: T): Resource<T>()
    class Loading<out T>(): Resource<T>()
}