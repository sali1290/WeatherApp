package com.e.domain.models.usermodel

data class CurrentModel(
    val temp: Float,

    val feelsLike: Float,

    val pressure: Float,

    val humidity: Float,

    val uvi: Float,

    val weatherModel: WeatherModel,
)