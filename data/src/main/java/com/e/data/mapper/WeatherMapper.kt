package com.e.data.mapper

import com.e.data.entity.user.Weather
import com.e.domain.models.usermodel.WeatherModel
import javax.inject.Inject

class WeatherMapper @Inject constructor() {
    fun toMapper(weather: Weather): WeatherModel {
        return WeatherModel(
            weather.id,
            weather.main,
            weather.desc
        )
    }
}