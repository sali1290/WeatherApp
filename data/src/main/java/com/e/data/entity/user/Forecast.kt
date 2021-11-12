package com.e.data.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Forecast(
    @Json(name = "temp")
    val temp: ForecastTemp,

    @Json(name = "pressure")
    val pressure: Int,

    @Json(name = "humidity")
    val humidity: Int,

    @Json(name = "uvi")
    val uvi: Float,

    @Json(name = "weather")
    val weatherList: MutableList<Weather>,
)
