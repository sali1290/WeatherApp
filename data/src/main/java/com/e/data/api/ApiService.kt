package com.e.data.api

import com.e.data.entity.chosen.ChosenCityResponse
import com.e.data.entity.user.UserCityResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface ApiService {


    @GET("https://api.openweathermap.org/data/2.5/onecall")
    @FormUrlEncoded
    suspend fun getUserCityWeather(
        @Field("lat") latitude: Float,
        @Field("lon") longitude: Float,
        @Field("exclude") exclude: String,
        @Field("appid") apiKey: String,
    ): Response<UserCityResponse>

    @GET("api.openweathermap.org/data/2.5/weather")
    @FormUrlEncoded
    suspend fun getChosenCityWeather(
        @Field("q") q: String,
        @Field("appid") appId: String,
    ): Response<ChosenCityResponse>


}