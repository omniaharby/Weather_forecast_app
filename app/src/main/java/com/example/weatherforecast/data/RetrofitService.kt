package com.example.weatherforecast.data

import retrofit2.http.GET

interface JsonPlaceholderApi {
    @GET("/forecast")
    suspend fun getForecast(): List<WeatherAPIResponse>
}