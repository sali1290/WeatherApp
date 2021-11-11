package com.e.domain.repository

import com.e.domain.models.chosenmodel.ChosenCityResponseModel

interface GetChosenCityWeatherRepo {

    suspend fun getChosenCityWeather(cityName: String): ChosenCityResponseModel

}