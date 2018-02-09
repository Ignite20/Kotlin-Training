package com.tests.amadalingradinaru.kotlin2.domain

import com.tests.amadalingradinaru.kotlin2.data.ResponseClasses
import com.tests.amadalingradinaru.kotlin2.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*

/**
 * Created by a.madalin.gradinaru on 16/01/2018.
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ResponseClasses.ForecastResult): ModelForecast.ForecastList {
        return ModelForecast.ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
        }

    private fun convertForecastListToDomain(list: List<ResponseClasses.Forecast>):
            List<ModelForecast.Forecast> {
        return list.map { convertForecastItemToDomain(it) }
        }

    private fun convertForecastItemToDomain(forecast: ResponseClasses.Forecast): ModelForecast.Forecast {
        return ModelForecast.Forecast(
                convertDate(forecast.dt),
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
        }

    private fun generateIconUrl(iconCode: String) : String
            = "http://openweathermap.org/img/w/$iconCode.png"


    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                 Locale.getDefault())
        return df.format(date * 1000)
        }
}