package com.e.data.api

import com.e.data.entity.chosen.ChosenCityResponse
import com.e.data.entity.user.UserCityResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("onecall")
    suspend fun getUserCityWeather(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("exclude") exclude: String,
        @Query("appid") apiKey: String,
    ): Response<UserCityResponse>

    @GET("weather")
    suspend fun getChosenCityWeather(
        @Query("q") q: String,
        @Query("appid") appId: String,
    ): Response<ChosenCityResponse>


}