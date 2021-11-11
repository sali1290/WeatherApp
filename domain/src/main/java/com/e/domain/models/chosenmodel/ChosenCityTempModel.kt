package com.e.domain.models.chosenmodel

import com.e.domain.models.usermodel.WeatherModel

data class ChosenCityTempModel(

    val temp: Float,

    val feelsLike: Float,

    val tempMin: Float,

    val tempMax: Float,

    val pressure: Float,

    val humidity: Float,

    )
