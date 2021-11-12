package com.e.data.mapper

import com.e.data.entity.chosen.ChosenCord
import com.e.data.entity.user.UserCityResponse
import com.e.domain.models.chosenmodel.ChosenCordModel
import com.e.domain.models.usermodel.UserCityResponseModel
import javax.inject.Inject

class ChosenCordMapper @Inject constructor() {

    fun toMapper(chosenCord: ChosenCord): ChosenCordModel {
        return ChosenCordModel(
            chosenCord.lat,
            chosenCord.lon,
        )
    }

}