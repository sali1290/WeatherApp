package com.e.data.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserCityResponse(

    @Json(name = "lat")
    val lat: Float,

    @Json(name = "lon")
    val lon: Float,

    @Json(name = "timezone")
    val timezone: String,

    @Json(name = "current")
    val current: Current,

    @Json(name = "hourly")
    val hourly: MutableList<Current>,

    @Json(name = "daily")
    val daily: MutableList<Forecast>,


    )
