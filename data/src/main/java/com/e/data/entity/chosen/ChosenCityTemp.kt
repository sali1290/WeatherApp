package com.e.data.entity.chosen

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChosenCityTemp(
    @Json(name = "temp")
    val temp: Float,

    @Json(name = "feels_like")
    val feelsLike: Float,

    @Json(name = "temp_min")
    val tempMin: Float,

    @Json(name = "temp_max")
    val tempMax: Float,

    @Json(name = "pressure")
    val pressure: Int,

    @Json(name = "humidity")
    val humidity: Int,
)

