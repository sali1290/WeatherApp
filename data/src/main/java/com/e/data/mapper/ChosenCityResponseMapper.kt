package com.e.data.mapper

import com.e.data.entity.chosen.ChosenCityResponse
import com.e.domain.models.chosenmodel.ChosenCityResponseModel
import javax.inject.Inject

class ChosenCityResponseMapper @Inject constructor() {

    fun toMapper(chosenCityResponse: ChosenCityResponse): ChosenCityResponseModel {
        return ChosenCityResponseModel(
            ChosenCordMapper().toMapper(chosenCityResponse.cord),
            chosenCityResponse.weatherList.map {
                WeatherMapper().toMapper(it)
            }.toMutableList(),
            ChosenCityTempMapper().toMapper(chosenCityResponse.chosenCityTemp),
            chosenCityResponse.name
        )
    }


}