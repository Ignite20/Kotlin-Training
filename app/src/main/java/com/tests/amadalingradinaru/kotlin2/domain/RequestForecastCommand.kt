package com.tests.amadalingradinaru.kotlin2.domain

import com.tests.amadalingradinaru.kotlin2.data.ForecastRequest
import com.tests.amadalingradinaru.kotlin2.domain.model.Forecast
import com.tests.amadalingradinaru.kotlin2.domain.model.Forecast.ForecastList

/**
 * Created by a.madalin.gradinaru on 09/02/2018.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}