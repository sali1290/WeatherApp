package com.e.data.mapper

import com.e.data.entity.user.Current
import com.e.domain.models.usermodel.CurrentModel
import javax.inject.Inject

class CurrentMapper @Inject constructor() {
    fun toMapper(current: Current): CurrentModel {
        return CurrentModel(
            current.temp,
            current.feelsLike,
            current.pressure,
            current.humidity,
            current.uvi,
            current.weatherList.map {
                WeatherMapper().toMapper(it)
            }.toMutableList()
        )
    }
}