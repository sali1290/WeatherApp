package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityResponse(

    @Json(name = "lat")
    val time: Int,

    @Json(name = "lat")
    val lat: Float,

    @Json(name = "lon")
    val lon: Float,

    @Json(name = "lat")
    val current: Current,

    @Json(name = "lat")
    val hourly: Hourly,

    @Json(name = "lat")
    val daily: Daily,


    )
