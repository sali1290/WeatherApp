package com.e.domain.models.usermodel

data class ForeCastTempModel(
    val day: Float,

    val min: Float,

    val max: Float,

    val night: Float,

    val eve: Float,

    val morn: Float,
)