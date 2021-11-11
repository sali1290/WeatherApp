package com.e.data.api

import com.e.data.entity.user.UserCityResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface ApiService {


    @GET
    @FormUrlEncoded
    suspend fun getUserCityWeather(
        @Field ("lat") latitude: Float,
        @Field ("lat") longitude: Float,
        @Field ("lat") exclude: String,
        @Field ("lat") apiKey: String,
    ):Response<UserCityResponse>

    @GET
    @FormUrlEncoded
    suspend fun getChosenCityWeather(
        @Field ("lat") latitude: Float,
        @Field ("lat") longitude: Float,
        @Field ("lat") exclude: String,
        @Field ("lat") apiKey: String,
    ):Response<UserCityResponse>



}