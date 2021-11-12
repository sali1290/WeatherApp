package com.e.data.mapper

import com.e.data.entity.chosen.ChosenCityTemp
import com.e.domain.models.chosenmodel.ChosenCityTempModel
import javax.inject.Inject

class ChosenCityTempMapper @Inject constructor() {

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