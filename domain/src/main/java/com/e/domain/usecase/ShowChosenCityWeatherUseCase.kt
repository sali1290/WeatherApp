package com.e.domain.usecase

import com.e.domain.repository.GetChosenCityWeather
import javax.inject.Inject


class ShowChosenCityWeatherUseCase @Inject constructor(private val getChosenCityWeather: GetChosenCityWeather) {

}