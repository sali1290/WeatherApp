package com.e.domain.usecase

import com.e.domain.repository.GetChosenCityWeatherRepo
import javax.inject.Inject


class ShowChosenCityWeatherUseCase @Inject constructor(private val getChosenCityWeatherRepo: GetChosenCityWeatherRepo) {

    suspend fun execute(name: String) = getChosenCityWeatherRepo.getChosenCityWeather(name)

}