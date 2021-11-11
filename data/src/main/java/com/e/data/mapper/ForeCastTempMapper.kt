package com.e.data.mapper

import com.e.data.entity.user.ForecastTemp
import com.e.domain.models.usermodel.ForeCastModel
import com.e.domain.models.usermodel.ForeCastTempModel

class ForeCastTempMapper {
    fun toMapper(foreCastTemp: ForecastTemp): ForeCastTempModel {
        return ForeCastTempModel(
            foreCastTemp.day,
            foreCastTemp.min,
            foreCastTemp.max,
            foreCastTemp.night,
            foreCastTemp.eve,
            foreCastTemp.morn
        )
    }
}