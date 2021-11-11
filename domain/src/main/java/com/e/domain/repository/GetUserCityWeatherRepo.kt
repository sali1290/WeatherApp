package com.e.domain.repository

import com.e.domain.models.usermodel.UserCityResponseModel

interface GetUserCityWeatherRepo {

    suspend fun getCurrentWeather(lat: Float, lon: Float): UserCityResponseModel

}