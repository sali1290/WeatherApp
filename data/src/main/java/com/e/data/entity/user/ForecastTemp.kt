package com.e.data.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastTemp(
    @Json(name = "day")
    val day: Float,

    @Json(name = "min")
    val min: Float,

    @Json(name = "max")
    val max: Float,

    @Json(name = "night")
    val night: Float,

    @Json(name = "eve")
    val eve: Float,

    @Json(name = "morn")
    val morn: Float,
)
