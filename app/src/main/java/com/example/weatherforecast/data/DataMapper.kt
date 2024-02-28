package com.example.weatherforecast.data

import com.example.weatherforecast.data.datasource.WeatherAPIResponse
import com.example.weatherforecast.domain.Condition
import com.example.weatherforecast.domain.CurrentWeather
import com.example.weatherforecast.domain.DailyWeather
import com.example.weatherforecast.domain.HourlyWeather
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun mapResponseToDailyWeather(response: WeatherAPIResponse): DailyWeather {

    return DailyWeather(
        CurrentWeather(
            country = response.location.name,
            degree = "${response.current.tempC.toInt()}",
            condition = Condition.fromValue(response.current.condition.text.trim().toLowerCase()),
            high = "${response.forecast.forecastday[0].day.maxtempC.toInt()}",
            low = "${response.forecast.forecastday[0].day.maxtempC}"
        ),
        hourlyWeather = response.forecast.forecastday[0].hour.map {
            HourlyWeather(
                time = formatDateFromTimestamp(it.timeEpoch, timePattern),
                condition = Condition.fromValue(it.condition.text.trim().toLowerCase()),
                degree = "${it.tempC.toInt()}"
            )
        }
    )
}


fun formatDateFromTimestamp(timestamp: Long, pattern: String): String {
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    return sdf.format(Date(timestamp))
}

const val timePattern = "HH:mm"