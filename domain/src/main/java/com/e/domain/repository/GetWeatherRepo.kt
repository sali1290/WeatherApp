package com.e.domain.repository

import com.e.domain.models.usermodel.UserCityResponseModel

interface GetWeatherRepo {

    suspend fun getCurrentWeather(): UserCityResponseModel

}