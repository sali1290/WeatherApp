package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Current(
    @Json(name = "temp")
    val temp: Float,

    @Json(name = "feels_like")
    val feelsLike: Float,

    @Json(name = "pressure")
    val pressure: Float,

    @Json(name = "humidity")
    val humidity: Float,

    @Json(name = "uvi")
    val uvi: Float,

    @Json(name = "weather")
    val weather: Weather,


    )