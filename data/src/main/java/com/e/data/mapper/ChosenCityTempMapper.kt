package com.e.data.mapper

import com.e.data.entity.chosen.ChosenCityTemp
import com.e.domain.models.chosenmodel.ChosenCityTempModel

class ChosenCityTempMapper {

    fun toMapper(chosenCityTemp: ChosenCityTemp): ChosenCityTempModel {
        return ChosenCityTempModel(
            chosenCityTemp.temp,
            chosenCityTemp.feelsLike,
            chosenCityTemp.tempMin,
            chosenCityTemp.tempMax,
            chosenCityTemp.pressure,
            chosenCityTemp.humidity,

            )
    }

}