package com.e.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.domain.Result
import com.e.domain.models.chosenmodel.ChosenCityResponseModel
import com.e.domain.usecase.ShowChosenCityWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetChosenCityWeatherViewModel @Inject constructor(
    private val chosenCityWeatherUseCase: ShowChosenCityWeatherUseCase
) : ViewModel() {

    private val _chosenCityResponse = MutableLiveData<Result<ChosenCityResponseModel>>()
    val chosenCityResponse: LiveData<Result<ChosenCityResponseModel>>
        get() = _chosenCityResponse

    private val handler = CoroutineExceptionHandler { _, exception ->
        _chosenCityResponse.postValue(exception.message.let { Result.Error(it!!) })
    }

    fun getChosenCity(name: String) = viewModelScope.launch(Dispatchers.IO + handler) {
        _chosenCityResponse.postValue(Result.Loading)
        chosenCityWeatherUseCase.execute(name).let {
            _chosenCityResponse.postValue(Result.Success(it))
        }

    }

}