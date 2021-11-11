package com.e.data.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "id")
    val id: Int,

    @Json(name = "main")
    val main: String,

    @Json(name = "description")
    val desc: String
)
