package com.e.weatherapp.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.weatherapp.databinding.FragmentShowUserCityBinding
import com.e.weatherapp.viewmodel.GetUserCityWeatherViewModel
import com.google.android.gms.location.*
import dagger.hilt.android.AndroidEntryPoint
import com.e.weatherapp.R
import com.e.weatherapp.adapter.HourlyAdapter


@AndroidEntryPoint
class ShowUserCityFragment : Fragment() {

    private lateinit var binding: FragmentShowUserCityBinding
    private lateinit var viewModel: GetUserCityWeatherViewModel

    lateinit var fuseLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest: LocationRequest

    private val permissionFineLocation = 5

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentShowUserCityBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(requireActivity()).get(GetUserCityWeatherViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startTracking()


    }

    private fun startTracking() {
        locationRequest = LocationRequest.create()
        locationRequest.apply {
            interval = 30000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        fuseLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())

        val locationCallBack = object : LocationCallback() {
            override fun onLocationResult(locationResualt: LocationResult) {
                super.onLocationResult(locationResualt)
                viewModel.getUserCityWeather(
                    locationResualt.lastLocation.latitude.toFloat(),
                    locationResualt.lastLocation.longitude.toFloat()
                )
                observe()
            }

            override fun onLocationAvailability(locationAvailability: LocationAvailability) {
                super.onLocationAvailability(locationAvailability)
            }
        }
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                permissionFineLocation
            )
        } else {
            fuseLocationProviderClient.requestLocationUpdates(
                locationRequest,
                locationCallBack,
                null
            )
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == permissionFineLocation) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startTracking()
            } else {
                requireActivity().finish()
            }
        }

    }

    private fun observe() {
        viewModel.userCityResponse.observe(viewLifecycleOwner, {
            when (it) {
                is Result.Success -> {
                    val temp = (it.data.currentModel.temp - 273).toInt()
                    binding.tvTemp.text = temp.toString() + "C"
                    when (it.data.currentModel.weatherListModel[0].desc) {

                        "clear sky" -> {
                            binding.imgIcon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    requireContext(),
                                    R.drawable.ic_sun
                                )
                            )
                        }

                        "mist" -> {
                            binding.imgIcon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    requireContext(),
                                    R.drawable.ic_mist
                                )
                            )
                        }

                        "snow" -> {
                            binding.imgIcon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    requireContext(),
                                    R.drawable.ic_snow
                                )
                            )
                        }

                        "few clouds" -> {
                            binding.imgIcon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    requireContext(),
                                    R.drawable.ic_few_clouds
                                )
                            )
                        }

                        "rain" -> {
                            binding.imgIcon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    requireContext(),
                                    R.drawable.ic_rain
                                )
                            )
                        }

                        "shower rain" -> {
                            binding.imgIcon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    requireContext(),
                                    R.drawable.ic_rain
                                )
                            )
                        }

                        else -> {
                            binding.imgIcon.setImageDrawable(
                                AppCompatResources.getDrawable(
                                    requireContext(),
                                    R.drawable.ic_clouds
                                )
                            )
                        }


                    }
                    binding.tvWeatherCo.text = it.data.currentModel.weatherListModel[0].main
                    binding.tvCity.text = it.data.timezone
                    binding.tvUvIndex.text = it.data.currentModel.uvi.toString()
                    binding.tvWindSpeed.text = it.data.currentModel.windSpeed.toString() + "Km/h"
                    binding.tvHumidity.text = it.data.currentModel.humidity.toString() + "%"

                    binding.hourlyRecycler.adapter = HourlyAdapter(it.data, requireContext())
                }

                is Result.Loading -> {

                }

                is Result.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    // use this for times that other app using GPS before
//    private fun updateGPS() {
//        locationRequest = LocationRequest.create()
//        locationRequest.apply {
//            interval = 30000
//            fastestInterval = 5000
//            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        }
//        fuseLocationProviderClient =
//            LocationServices.getFusedLocationProviderClient(requireActivity())
//
//        if (ActivityCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            fuseLocationProviderClient.lastLocation.addOnSuccessListener(requireActivity()) {
//                if (it == null) {
//                    Toast.makeText(requireContext(), "لطفا GPS خود را روشن کنید", Toast.LENGTH_LONG)
//                        .show()
//                } else {
//                    viewModel.getUserCityWeather(it.latitude.toFloat(), it.longitude.toFloat())
//                    observe()
//                }
//            }
//
//        } else {
//            requestPermissions(
//                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
//                permissionFineLocation
//            )
//        }
//    }


}