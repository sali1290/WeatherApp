package com.e.data.mapper

import com.e.data.entity.user.Forecast
import com.e.data.entity.user.UserCityResponse
import com.e.domain.models.usermodel.ForeCastModel
import com.e.domain.models.usermodel.UserCityResponseModel

class ForeCastMapper {
    fun toMapper(foreCast: Forecast): ForeCastModel {
        return ForeCastModel(
            ForeCastTempMapper().toMapper(foreCast.temp),
            foreCast.pressure,
            foreCast.humidity,
            foreCast.uvi,
            WeatherMapper().toMapper(foreCast.weather)
        )
    }
}