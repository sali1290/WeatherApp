package com.e.weatherapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.e.weatherapp.R

class ShowChosenDayInfoActivity : AppCompatActivity() {

    private lateinit var icon: ImageView
    private lateinit var tvDay: TextView
    private lateinit var tvPressure: TextView
    private lateinit var tvUvi: TextView
    private lateinit var tvHumidity: TextView
    private lateinit var tvWeather: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_chosen_day_info)

        icon = findViewById(R.id.img_chosen_day)
        tvDay = findViewById(R.id.tv_chosen_day)
        tvPressure = findViewById(R.id.tv_chosen_day_pressure)
        tvUvi = findViewById(R.id.tv_chosen_day_uvi)
        tvHumidity = findViewById(R.id.tv_chosen_day_humidity)
        tvWeather = findViewById(R.id.tv_chosen_day_weather)

        val bundle = intent.extras
        bundle!!.apply {
            when (getInt("day")) {
                1 -> {
                    tvDay.text = "Sunday"
                }
                2 -> {
                    tvDay.text = "Monday"
                }
                3 -> {
                    tvDay.text = "Tuesday"
                }
                4 -> {
                    tvDay.text = "Wednesday"
                }
                5 -> {
                    tvDay.text = "Thursday"
                }
                6 -> {
                    tvDay.text = "Friday"
                }
                7 -> {
                    tvDay.text = "Saturday"
                }
            }
            tvPressure.text = getString("pressure")
            tvUvi.text = getString("uvi")
            tvHumidity.text = getString("humidity")
            when (getString("desc")) {

                "clear sky" -> {
                    icon.setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.ic_sun
                        )
                    )
                }

                "mist" -> {
                    icon.setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.ic_mist
                        )
                    )
                }

                "snow" -> {
                    icon.setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.ic_snow
                        )
                    )
                }

                "few clouds" -> {
                    icon.setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.ic_few_clouds
                        )
                    )
                }

                "rain" -> {
                    icon.setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.ic_rain
                        )
                    )
                }

                "shower rain" -> {
                    icon.setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.ic_rain
                        )
                    )
                }

                else -> {
                    icon.setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.ic_clouds
                        )
                    )
                }


            }
            tvWeather.text = getString("desc")
        }


    }
}