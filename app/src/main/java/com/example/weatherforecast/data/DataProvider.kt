package com.example.weatherforecast.data

import android.util.Log
import com.example.weatherforecast.BuildConfig
import com.example.weatherforecast.data.datasource.Response
import com.example.weatherforecast.data.datasource.RetrofitInstance
import com.example.weatherforecast.domain.DailyWeather
import javax.inject.Inject

class DataProvider @Inject constructor() {
    suspend fun fetchData(location: String): Response<DailyWeather> {
        val apiKey=BuildConfig.API_KEY
        val days = 1
        val includeAqi = "no"
        val includeAlerts = "no"
        return try {
            Response.Success(
                mapResponseToDailyWeather(
                    RetrofitInstance.api.getWeatherForecast(
                        apiKey, location, days, includeAqi, includeAlerts
                    )
                )
            )
        } catch (e: Exception ) {
            Log.e("Error", "Error fetching data from weather Api")
            Response.Failure("Error fetching data from weather Api ${e.message }")
        }
    }
}