package com.example.weatherforecast.data

import com.google.gson.annotations.SerializedName

data class WeatherAPIResponse(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

data class Current(
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Long,

    @SerializedName("last_updated")
    val lastUpdated: String,

    @SerializedName("temp_c")
    val tempC: Double,

    @SerializedName("temp_f")
    val tempF: Double,

    @SerializedName("is_day")
    val isDay: Long,

    val condition: Condition,

    @SerializedName("wind_mph")
    val windMph: Double,

    @SerializedName("wind_kph")
    val windKph: Double,

    @SerializedName("wind_degree")
    val windDegree: Long,

    @SerializedName("pressure_mb")
    val pressureMB: Double,

    @SerializedName("pressure_in")
    val pressureIn: Double,

    @SerializedName("precip_mm")
    val precipMm: Double,

    @SerializedName("precip_in")
    val precipIn: Double,

    val humidity: Long,
    val cloud: Long,

    @SerializedName("feelslike_c")
    val feelslikeC: Double,

    @SerializedName("feelslike_f")
    val feelslikeF: Double,

    @SerializedName("vis_km")
    val visKM: Double,

    @SerializedName("vis_miles")
    val visMiles: Double,

    val uv: Double,

    @SerializedName("gust_mph")
    val gustMph: Double,

    @SerializedName("gust_kph")
    val gustKph: Double
)

data class Condition(
    val text: String,
    val icon: String,
    val code: Long
)


data class Forecast(
    val forecastday: List<Forecastday>
)

data class Forecastday(
    val date: String,

    @SerializedName("date_epoch")
    val dateEpoch: Long,

    val day: Day,
    val astro: Astro,
    val hour: List<Hour>
)

data class Astro(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,

    @SerializedName("moon_phase")
    val moonPhase: String,

    @SerializedName("moon_illumination")
    val moonIllumination: Long,

    @SerializedName("is_moon_up")
    val isMoonUp: Long,

    @SerializedName("is_sun_up")
    val isSunUp: Long
)

data class Day(
    @SerializedName("maxtemp_c")
    val maxtempC: Double,

    @SerializedName("maxtemp_f")
    val maxtempF: Double,

    @SerializedName("mintemp_c")
    val mintempC: Double,

    @SerializedName("mintemp_f")
    val mintempF: Double,

    @SerializedName("avgtemp_c")
    val avgtempC: Double,

    @SerializedName("avgtemp_f")
    val avgtempF: Double,

    @SerializedName("maxwind_mph")
    val maxwindMph: Double,

    @SerializedName("maxwind_kph")
    val maxwindKph: Double,

    @SerializedName("totalprecip_mm")
    val totalprecipMm: Double,

    @SerializedName("totalprecip_in")
    val totalprecipIn: Double,

    @SerializedName("totalsnow_cm")
    val totalsnowCM: Double,

    @SerializedName("avgvis_km")
    val avgvisKM: Double,

    @SerializedName("avgvis_miles")
    val avgvisMiles: Double,

    val avghumidity: Long,

    @SerializedName("daily_will_it_rain")
    val dailyWillItRain: Long,

    @SerializedName("daily_chance_of_rain")
    val dailyChanceOfRain: Long,

    @SerializedName("daily_will_it_snow")
    val dailyWillItSnow: Long,

    @SerializedName("daily_chance_of_snow")
    val dailyChanceOfSnow: Long,

    val condition: Condition,
    val uv: Double
)

data class Hour(
    @SerializedName("time_epoch")
    val timeEpoch: Long,

    val time: String,

    @SerializedName("temp_c")
    val tempC: Double,

    @SerializedName("temp_f")
    val tempF: Double,

    @SerializedName("is_day")
    val isDay: Long,

    val condition: Condition,

    @SerializedName("pressure_mb")
    val pressureMB: Double,

    @SerializedName("pressure_in")
    val pressureIn: Double,

    @SerializedName("precip_mm")
    val precipMm: Double,

    @SerializedName("precip_in")
    val precipIn: Double,

    @SerializedName("snow_cm")
    val snowCM: Double,

    val humidity: Long,
    val cloud: Long,

    @SerializedName("will_it_rain")
    val willItRain: Long,

    @SerializedName("chance_of_rain")
    val chanceOfRain: Long,

    @SerializedName("will_it_snow")
    val willItSnow: Long,

    @SerializedName("chance_of_snow")
    val chanceOfSnow: Long,

    val uv: Double,
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,

    @SerializedName("tz_id")
    val tzID: String,

    @SerializedName("localtime_epoch")
    val localtimeEpoch: Long,

    val localtime: String
)