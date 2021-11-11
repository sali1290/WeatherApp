package com.e.domain.models.usermodel

data class ForeCastModel(

    val temp: ForeCastTempModel,

    val pressure: Float,

    val humidity: Float,

    val uvi: Float,

    val weather: WeatherModel,
)
