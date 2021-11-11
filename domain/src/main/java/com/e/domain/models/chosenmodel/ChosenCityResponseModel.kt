package com.e.domain.models.chosenmodel

import com.e.domain.models.usermodel.WeatherModel

data class ChosenCityResponseModel(

    val cord: ChosenCordModel,

    val weather: WeatherModel,

    val chosenCityTemp: ChosenCityTempModel,

    val name: String

)