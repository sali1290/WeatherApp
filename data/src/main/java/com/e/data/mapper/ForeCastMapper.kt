package com.e.data.mapper

import com.e.data.entity.user.Forecast
import com.e.domain.models.usermodel.ForeCastModel
import javax.inject.Inject

class ForeCastMapper @Inject constructor() {
    fun toMapper(foreCast: Forecast): ForeCastModel {
        return ForeCastModel(
            ForeCastTempMapper().toMapper(foreCast.temp),
            foreCast.pressure,
            foreCast.humidity,
            foreCast.uvi,
            foreCast.weatherList.map {
                WeatherMapper().toMapper(it)
            }.toMutableList()

        )
    }
}