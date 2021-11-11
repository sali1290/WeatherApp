package com.e.data.di

import com.e.data.repository.GetChosenCityWeatherImpl
import com.e.data.repository.GetUserCityWeatherImpl
import com.e.domain.repository.GetChosenCityWeatherRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindChosenCityWeather(
        getChosenCityWeatherImpl: GetChosenCityWeatherImpl
    ): GetChosenCityWeatherRepo

    @Binds
    abstract fun bindUserCityWeather(
        getUserCityWeatherImpl: GetUserCityWeatherImpl
    ): GetChosenCityWeatherRepo

}