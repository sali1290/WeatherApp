package com.e.domain.usecase

import com.e.domain.repository.GetWeatherRepo
import javax.inject.Inject

class ShowUserCityWeatherUseCase @Inject constructor(private val getWeatherRepo: GetWeatherRepo) {
}