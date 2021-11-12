package com.e.data.entity.chosen

import com.e.data.entity.user.Weather
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChosenCityResponse(

    @Json(name = "coord")
    val cord: ChosenCord,

    @Json(name = "weather")
    val weatherList: MutableList<Weather>,

    @Json(name = "main")
    val chosenCityTemp: ChosenCityTemp,

    @Json(name = "name")
    val name: String

)
