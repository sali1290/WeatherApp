package com.e.weatherapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.usermodel.UserCityResponseModel
import com.e.weatherapp.R

class HourlyAdapter(
    private val hourlyList: UserCityResponseModel,
    private val context: Context
) :
    RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder>() {

    inner class HourlyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTemp: TextView = itemView.findViewById(R.id.tv_hourly_temp)
        val textViewTime: TextView = itemView.findViewById(R.id.tv_hourly_time)
        val imageWeather: ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather_hourly, parent, false)
        return HourlyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        holder.textViewTemp.text = (hourlyList.hourlyModel[position].temp - 273).toInt().toString() + "C"
        holder.textViewTime.text = hourlyList.hourlyModel[position].weatherListModel[0].main

        when (hourlyList.hourlyModel[0].weatherListModel[0].desc) {

            "clear sky" -> {
                holder.imageWeather.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_sun
                    )
                )
            }

            "mist" -> {
                holder.imageWeather.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_mist
                    )
                )
            }

            "snow" -> {
                holder.imageWeather.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_snow
                    )
                )
            }

            "few clouds" -> {
                holder.imageWeather.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_few_clouds
                    )
                )
            }

            "rain" -> {
                holder.imageWeather.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_rain
                    )
                )
            }

            "shower rain" -> {
                holder.imageWeather.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_rain
                    )
                )
            }

            else -> {
                holder.imageWeather.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_clouds
                    )
                )
            }


        }

    }

    override fun getItemCount() = hourlyList.hourlyModel.size
}