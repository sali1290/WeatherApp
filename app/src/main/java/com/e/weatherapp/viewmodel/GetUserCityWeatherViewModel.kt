package com.e.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.domain.Result
import com.e.domain.models.usermodel.UserCityResponseModel
import com.e.domain.usecase.ShowUserCityWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetUserCityWeatherViewModel @Inject constructor(
    private val showUserCityWeatherUseCase: ShowUserCityWeatherUseCase
) : ViewModel() {

    private val _userCityResponse = MutableLiveData<Result<UserCityResponseModel>>()

    val userCityResponse: LiveData<Result<UserCityResponseModel>>
        get() = _userCityResponse

    private val handler = CoroutineExceptionHandler { _, exception ->
        _userCityResponse.postValue(Result.Error(exception.message!!))
    }

    fun getUserCityWeather(lat: Float, lon: Float) =
        viewModelScope.launch(Dispatchers.IO + handler) {
            _userCityResponse.postValue(Result.Loading)
            showUserCityWeatherUseCase.execute(lat, lon).let {
                _userCityResponse.postValue(Result.Success(it))
            }

        }
}