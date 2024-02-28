package com.example.weatherforecast.data.datasource

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int,
        @Query("aqi") includeAqi: String,
        @Query("alerts") includeAlerts: String
    ): WeatherAPIResponse
}