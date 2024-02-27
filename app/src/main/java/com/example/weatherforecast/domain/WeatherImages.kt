package com.example.weatherforecast.domain

import com.example.weatherforecast.R

enum class WeatherICon(val drawable: Int) {
    PartiallyCloudy(R.drawable.moon),
    Sunny(R.drawable.sun),
    Cloudy(R.drawable.cloudy),
    Windy(R.drawable.wind),
    ClearNight(R.drawable.crescentmoon),
    HeavyRain(R.drawable.heavyrain),
    PartiallyRaining(R.drawable.rainy),
    Overcast(R.drawable.overcast);
}

enum class WeatherBackGround(val drawable: Int) {
    WarmMorning(R.drawable.clearmorning),
    SkyWithCloudsMorning(R.drawable.cloudsmorning),
    ClearDawnSky(R.drawable.clearnight),
    ColdCLearSky(R.drawable.dawn),
    ColdFoggySky(R.drawable.fog),
    WarmCLearNight(R.drawable.moondessert),
    RainySky(R.drawable.rain),
    ColdIcyWeather(R.drawable.snow),
    SunSetClearSky(R.drawable.sunset)
}