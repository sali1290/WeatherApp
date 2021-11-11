package com.e.data.entity.user

import com.e.data.entity.user.Current
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hourly(
    val hourlyList: MutableList<Current>
)
