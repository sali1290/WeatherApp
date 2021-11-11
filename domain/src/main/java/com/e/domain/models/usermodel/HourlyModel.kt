package com.e.domain.models.usermodel

import com.e.domain.models.usermodel.CurrentModel

data class HourlyModel(
    val hourlyList: MutableList<CurrentModel>
)
