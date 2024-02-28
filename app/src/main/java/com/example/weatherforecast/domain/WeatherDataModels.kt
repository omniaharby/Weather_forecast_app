package com.example.weatherforecast.domain

data class CurrentWeather(
    val country: String,
    val degree: String,
    val condition: Condition,
    val high: String,
    val low: String
)

data class HourlyWeather(
    val time: String, val condition: Condition, val degree: String
)

data class DailyWeather(val dayWeather: CurrentWeather, val hourlyWeather: List<HourlyWeather>)

enum class Condition(val value: String) {
    Cloudy("cloudy"), Overcast("overcast"), PartlyCloudy("partly cloudy"), PatchyRainNearby("patchy rain nearby"), LightDrizzle(
        "light drizzle"
    ),
    Clear("clear"), Sunny("sunny"), LightRain("light rain");

    companion object {
        public fun fromValue(value: String): Condition = when (value) {
            "cloudy" -> Cloudy
            "overcast" -> Overcast
            "partly cloudy" -> PartlyCloudy
            "patchy rain nearby" -> PatchyRainNearby
            "clear" -> Clear
            "sunny" -> Sunny
            "light drizzle" -> LightDrizzle
            "light rain" -> LightRain
            else -> Cloudy
        }
    }
}
