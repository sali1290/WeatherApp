package com.e.domain.models.usermodel

data class ForeCastModel(

    val temp: ForeCastTempModel,

    val pressure: Int,

    val humidity: Int,

    val uvi: Float,

    val weather: MutableList<WeatherModel>,
)
