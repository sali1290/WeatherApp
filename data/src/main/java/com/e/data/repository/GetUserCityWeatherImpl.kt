package com.e.data.repository

import com.e.data.api.ApiService
import com.e.data.mapper.UserCityResponseMapper
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.usermodel.UserCityResponseModel
import com.e.domain.repository.GetUserCityWeatherRepo
import java.io.IOException
import javax.inject.Inject

class GetUserCityWeatherImpl @Inject constructor(
    private val userCityResponseMapper: dagger.Lazy<UserCityResponseMapper>,
    private val apiService: ApiService,
    private val netWorkHelper: NetWorkHelper
) : GetUserCityWeatherRepo {

    @Throws(IOException::class)
    override suspend fun getCurrentWeather(lat: Float, lon: Float): UserCityResponseModel {
        val apiId = "1ef5d86d477c361109176672d2582890"
        val exclude = "minutely"
        lateinit var userCityResponseModel: UserCityResponseModel

        val response = apiService.getUserCityWeather(lat, lon, exclude, apiId)
        if (netWorkHelper.isNetworkConnected()) {
            if (response.isSuccessful &&
                response.body() != null
            ) {
                userCityResponseModel = response.body().let {
                    userCityResponseMapper.get().toMapper(it!!)
                }

                return userCityResponseModel

            } else {
                throw IOException("Server is Not Responding")
            }

        } else {
            throw IOException("No Internet Connection")
        }

    }
}