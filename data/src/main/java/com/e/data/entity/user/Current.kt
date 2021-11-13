package com.e.data.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Current(
    @Json(name = "temp")
    val temp: Float,

    @Json(name = "feels_like")
    val feelsLike: Float,

    @Json(name = "pressure")
    val pressure: Int,

    @Json(name = "humidity")
    val humidity: Int,

    @Json(name = "uvi")
    val uvi: Float,

    @Json(name = "wind_speed")
    val windSpeed: Float,

    @Json(name = "weather")
    val weatherList: List<Weather>,


    )