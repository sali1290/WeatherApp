package com.e.data.entity.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Daily(
    val dailyList: MutableList<Forecast>
)
