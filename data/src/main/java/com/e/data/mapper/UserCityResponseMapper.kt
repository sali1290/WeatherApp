package com.e.data.mapper

import com.e.data.entity.user.UserCityResponse
import com.e.domain.models.usermodel.DailyModel
import com.e.domain.models.usermodel.HourlyModel
import com.e.domain.models.usermodel.UserCityResponseModel

class UserCityResponseMapper {

    fun toMapper(userCityResponse: UserCityResponse): UserCityResponseModel {
        return UserCityResponseModel(
            userCityResponse.lat,
            userCityResponse.lon,
            CurrentMapper().toMapper(userCityResponse.current),
            HourlyModel(
                userCityResponse.hourly.hourlyList.map {
                    CurrentMapper().toMapper(it)
                }.toMutableList()
            ),
            DailyModel(
                userCityResponse.daily.dailyList.map {
                    ForeCastMapper().toMapper(it)
                }.toMutableList()
            )
        )
    }

}