package com.e.domain.usecase

import com.e.domain.repository.GetUserCityWeatherRepo
import javax.inject.Inject

class ShowUserCityWeatherUseCase @Inject constructor(
    private val getUserCityWeatherRepo: GetUserCityWeatherRepo
) {

    suspend fun execute(lat: Float, lon: Float) = getUserCityWeatherRepo.getCurrentWeather(lat, lon)

}