package com.e.data.repository

import com.e.data.api.ApiService
import com.e.data.mapper.ChosenCityResponseMapper
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.chosenmodel.ChosenCityResponseModel
import com.e.domain.repository.GetChosenCityWeatherRepo
import java.io.IOException
import javax.inject.Inject

class GetChosenCityWeatherImpl @Inject constructor(
    private val chosenCityResponseMapper: dagger.Lazy<ChosenCityResponseMapper>,
    private val apiService: ApiService,
    private val netWorkHelper: NetWorkHelper
) : GetChosenCityWeatherRepo {

    @Throws(IOException::class)
    override suspend fun getChosenCityWeather(cityName: String): ChosenCityResponseModel {
        val apiId = "1ef5d86d477c361109176672d2582890"
        lateinit var chosenCityResponseModel: ChosenCityResponseModel

        val response = apiService.getChosenCityWeather(cityName, apiId)
        if (netWorkHelper.isNetworkConnected()) {
            if (response.isSuccessful && response.body() != null) {

                chosenCityResponseModel = response.body().let {
                    chosenCityResponseMapper.get().toMapper(it!!)
                }

                return chosenCityResponseModel

            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }
}