package com.tests.amadalingradinaru.kotlin2

import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.tests.amadalingradinaru.kotlin2.domain.RequestForecastCommand
import com.tests.amadalingradinaru.kotlin2.domain.model.Forecast
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {


    private var locationManager : LocationManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        // Create persistent LocationManager reference
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?


        async {
            val result = RequestForecastCommand("29001").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result, object : ForecastListAdapter.OnItemClickListener{
                    override fun invoke(forecast: Forecast.Forecast) {
                        toast(forecast.date)
                    }
                })
            }

        }


    }
}
