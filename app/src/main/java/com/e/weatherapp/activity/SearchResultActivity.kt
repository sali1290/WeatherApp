package com.e.weatherapp.activity

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.weatherapp.R
import com.e.weatherapp.viewmodel.GetChosenCityWeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultActivity : AppCompatActivity() {

    private lateinit var viewModel: GetChosenCityWeatherViewModel
    private lateinit var tvChosenCityTemp: TextView
    private lateinit var tvChosenCityName: TextView
    private lateinit var icon: ImageView
    private lateinit var feelsLike: TextView
    private lateinit var maxMin: TextView
    private lateinit var tvChosenCityWeather: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        tvChosenCityTemp = findViewById(R.id.tv_chosen_city_temp)
        icon = findViewById(R.id.imageView3)
        feelsLike = findViewById(R.id.tv_chosen_city_feels_like)
        maxMin = findViewById(R.id.tv_chosen_city_max_min)
        tvChosenCityName = findViewById(R.id.tv_chosen_city_name)
        tvChosenCityWeather = findViewById(R.id.tv_chosen_city_weather)


        viewModel =
            ViewModelProvider(this).get(GetChosenCityWeatherViewModel::class.java)

        val query = this.getSharedPreferences("searchResult", Context.MODE_PRIVATE)
            .getString("Key", null)

        if (!query.isNullOrEmpty()) {
            viewModel.getChosenCity(query)
            observe()
        } else {
            Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show()
        }


    }


    private fun observe() {
        viewModel.chosenCityResponse.observe({ lifecycle }, {
            when (it) {

                is Result.Success -> {
                    tvChosenCityName.text = it.data.name
                    tvChosenCityTemp.text =
                        (it.data.chosenCityTemp.temp - 273).toInt().toString() + "C"
                    feelsLike.text =
                        (it.data.chosenCityTemp.feelsLike - 273).toInt().toString() + "C"
                    maxMin.text = (it.data.chosenCityTemp.tempMax - 273).toInt().toString() + "C/" +
                            (it.data.chosenCityTemp.tempMin - 273).toInt().toString() + "C"
                    tvChosenCityWeather.text = it.data.weather[0].desc
                    when (it.data.weather[0].desc) {

                        "clear sky" -> {
                            icon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    this,
                                    R.drawable.ic_sun
                                )
                            )
                        }

                        "mist" -> {
                            icon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    this,
                                    R.drawable.ic_mist
                                )
                            )
                        }

                        "snow" -> {
                            icon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    this,
                                    R.drawable.ic_snow
                                )
                            )
                        }

                        "few clouds" -> {
                            icon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    this,
                                    R.drawable.ic_few_clouds
                                )
                            )
                        }

                        "rain" -> {
                            icon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    this,
                                    R.drawable.ic_rain
                                )
                            )
                        }

                        "shower rain" -> {
                            icon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    this,
                                    R.drawable.ic_rain
                                )
                            )
                        }

                        else -> {
                            icon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    this,
                                    R.drawable.ic_clouds
                                )
                            )
                        }

                    }
                }

                is Result.Loading -> {
                }

                is Result.Error -> {
                    Toast.makeText(this, "Wrong city name", Toast.LENGTH_SHORT).show()
                }

            }
        })

    }


}