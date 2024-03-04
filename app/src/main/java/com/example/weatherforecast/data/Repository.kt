package com.example.weatherforecast.data

import com.example.weatherforecast.data.datasource.Response
import com.example.weatherforecast.domain.DailyWeather
import javax.inject.Inject

class Repository @Inject constructor(val dataProvider: DataProvider) {
    suspend fun getForecastData(location: String): Response<DailyWeather> {
        return dataProvider.fetchData(location)
    }
}