package com.e.domain.models.usermodel

data class UserCityResponseModel(

    val lat: Float,

    val lon: Float,

    val currentModel: CurrentModel,

    val hourlyModel: HourlyModel,

    val dailyModel: DailyModel

)
