package com.e.weatherapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.usermodel.ForeCastModel
import com.e.weatherapp.R
import java.util.*

class ForeCastAdapter(
    private val dailyList: MutableList<ForeCastModel>,
    private val context: Context
) :
    RecyclerView.Adapter<ForeCastAdapter.ForeCastViewHolder>() {

    inner class ForeCastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textDay: TextView = itemView.findViewById(R.id.tv_day)
        val textTemp: TextView = itemView.findViewById(R.id.tv_forecast_temp)
        val image: ImageView = itemView.findViewById(R.id.img_forecast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForeCastViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather_forecast, parent, false)
        return ForeCastViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ForeCastViewHolder, position: Int) {
        val date = Calendar.getInstance()
        var day = date.get(Calendar.DAY_OF_WEEK) + position
        if (day > 7) {
            day -= 7
        }
        Log.i("myTag", day.toString())
        when (day) {

            1 -> {
                holder.textDay.text = "Sunday"
            }
            2 -> {
                holder.textDay.text = "Monday"
            }
            3 -> {
                holder.textDay.text = "Tuesday"
            }
            4 -> {
                holder.textDay.text = "Wednesday"
            }
            5 -> {
                holder.textDay.text = "Thursday"
            }
            6 -> {
                holder.textDay.text = "Friday"
            }
            7 -> {
                holder.textDay.text = "Saturday"
            }
        }

        when (dailyList[0].weather[0].desc) {

            "clear sky" -> {
                holder.image.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_sun
                    )
                )
            }

            "mist" -> {
                holder.image.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_mist
                    )
                )
            }

            "snow" -> {
                holder.image.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_snow
                    )
                )
            }

            "few clouds" -> {
                holder.image.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_few_clouds
                    )
                )
            }

            "rain" -> {
                holder.image.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_rain
                    )
                )
            }

            "shower rain" -> {
                holder.image.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_rain
                    )
                )
            }

            else -> {
                holder.image.setImageDrawable(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_clouds
                    )
                )
            }


        }

        holder.textTemp.text =
            (dailyList[position].temp.max - 273).toInt()
                .toString() + "C / " + (dailyList[0].temp.min - 273).toInt().toString() + "C"
    }

    override fun getItemCount() = dailyList.size


}