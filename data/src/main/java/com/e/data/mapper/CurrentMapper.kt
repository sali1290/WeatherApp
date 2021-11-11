package com.e.data.mapper

import com.e.data.entity.user.Current
import com.e.domain.models.usermodel.CurrentModel

class CurrentMapper {
    fun toMapper(current: Current): CurrentModel {
        return CurrentModel(
            current.temp,
            current.feelsLike,
            current.pressure,
            current.humidity,
            current.uvi,
            WeatherMapper().toMapper(current.weather)
        )
    }
}