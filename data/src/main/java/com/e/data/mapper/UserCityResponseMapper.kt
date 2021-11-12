package com.e.data.mapper

import com.e.data.entity.user.UserCityResponse
import com.e.domain.models.usermodel.UserCityResponseModel
import javax.inject.Inject

class UserCityResponseMapper @Inject constructor() {

    fun toMapper(userCityResponse: UserCityResponse): UserCityResponseModel {
        return UserCityResponseModel(
            userCityResponse.lat,
            userCityResponse.lon,
            userCityResponse.timezone,
            CurrentMapper().toMapper(userCityResponse.current),
            userCityResponse.hourly.map {
                CurrentMapper().toMapper(it)
            }.toMutableList(),
            userCityResponse.daily.map {
                ForeCastMapper().toMapper(it)
            }.toMutableList()

        )
    }

}