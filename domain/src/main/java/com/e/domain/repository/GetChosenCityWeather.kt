package com.e.domain.repository

import com.e.domain.models.chosenmodel.ChosenCityResponseModel

interface GetChosenCityWeather {

    suspend fun getChosenCityWeather(): ChosenCityResponseModel

}