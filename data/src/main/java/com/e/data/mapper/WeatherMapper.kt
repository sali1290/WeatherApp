package com.e.data.mapper

import com.e.data.entity.user.Current
import com.e.data.entity.user.Weather
import com.e.domain.models.usermodel.CurrentModel
import com.e.domain.models.usermodel.WeatherModel

class WeatherMapper {
    fun toMapper(weather: Weather): WeatherModel {
        return WeatherModel(
            weather.id ,
            weather.main,
            weather.desc
        )
    }
}