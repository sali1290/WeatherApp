package com.e.data.entity.chosen

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChosenCord(
    @Json(name = "lon")
    val lon: Float,

    @Json(name = "lat")
    val lat: Float
)
