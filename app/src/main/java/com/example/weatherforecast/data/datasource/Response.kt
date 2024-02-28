package com.example.weatherforecast.data.datasource

sealed class Response<out T> {
    class Success<out T>(val data: T) : Response<T>()
    class Failure(val message: String) : Response<Nothing>()
}