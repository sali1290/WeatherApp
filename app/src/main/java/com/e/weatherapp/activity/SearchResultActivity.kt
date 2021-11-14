package com.e.weatherapp.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.weatherapp.R
import com.e.weatherapp.viewmodel.GetChosenCityWeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultActivity : AppCompatActivity() {

    private lateinit var viewModel: GetChosenCityWeatherViewModel
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        textView = findViewById(R.id.textView)

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
                    textView.text = it.data.name
                }

                is Result.Loading -> {
                }

                is Result.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }

            }
        })

    }


}