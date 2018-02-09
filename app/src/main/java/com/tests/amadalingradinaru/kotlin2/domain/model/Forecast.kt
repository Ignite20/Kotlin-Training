package com.tests.amadalingradinaru.kotlin2.domain.model

import com.tests.amadalingradinaru.kotlin2.domain.model.Forecast.Forecast

/**
 * Created by a.madalin.gradinaru on 16/01/2018.
 */
class Forecast {
    data class ForecastList(val city: String,
                            val country: String,
                            val dailyForecast:List<Forecast>){
        operator fun get(position: Int): Forecast = dailyForecast[position]
        fun size(): Int = dailyForecast.size
    }

    data class Forecast(val date: String,
                        val description: String,
                        val high: Int,
                        val low: Int,
                        val iconUrl: String)
}