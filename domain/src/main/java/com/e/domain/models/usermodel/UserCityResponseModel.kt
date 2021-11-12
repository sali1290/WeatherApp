package com.e.domain.models.usermodel

data class UserCityResponseModel(

    val lat: Float,

    val lon: Float,

    val timezone: String,

    val currentModel: CurrentModel,

    val hourlyModel: MutableList<CurrentModel>,

    val dailyModel: MutableList<ForeCastModel>

)
