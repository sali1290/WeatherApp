package com.e.domain.models.usermodel

data class CurrentModel(
    val temp: Float,

    val feelsLike: Float,

    val pressure: Int,

    val humidity: Int,

    val uvi: Float,

    val weatherListModel: MutableList<WeatherModel>,
)