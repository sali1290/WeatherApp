package com.e.data.mapper

import com.e.data.entity.chosen.ChosenCityResponse
import com.e.domain.models.chosenmodel.ChosenCityResponseModel

class ChosenCityResponseMapper {

    fun toMapper(chosenCityResponse: ChosenCityResponse): ChosenCityResponseModel {
        return ChosenCityResponseModel(
            ChosenCordMapper().toMapper(chosenCityResponse.cord),
            WeatherMapper().toMapper(chosenCityResponse.weather),
            ChosenCityTempMapper().toMapper(chosenCityResponse.chosenCityTemp),
            chosenCityResponse.name
        )
    }


}