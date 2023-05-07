package com.hakaninc.weather_app

import com.hakaninc.weather_app.model.Info
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiService {

    private val BASE_URL = "https://api.openweathermap.org/"
    private val api = Retrofit.Builder().baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherAPI::class.java)

    fun getData(): Single<Info>{
        return api.getWeather()
    }
}