package com.tests.amadalingradinaru.kotlin2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tests.amadalingradinaru.kotlin2.domain.model.Forecast
import com.tests.amadalingradinaru.kotlin2.domain.model.Forecast.ForecastList
import org.jetbrains.anko.find

/**
 * Created by a.madalin.gradinaru on 16/01/2018.
 */
class ForecastListAdapter(private val weekForecast: ForecastList,
                          val itemClick: OnItemClickListener):
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view, itemClick)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bindForecast(weekForecast[position])


    override fun getItemCount(): Int = weekForecast.size()

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast.Forecast)
    }

    class ViewHolder(view: View, val itemClick: OnItemClickListener): RecyclerView.ViewHolder(view){
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val minTemperatureView: TextView
        private val maxTemperatureView: TextView

        init {
            iconView = view.find(R.id.iv_icon)
            dateView = view.find(R.id.tv_date)
            descriptionView = view.find(R.id.tv_description)
            minTemperatureView = view.find(R.id.tv_minTemperature)
            maxTemperatureView = view.find(R.id.tv_maxTemperature)
        }

        fun bindForecast(forecast: Forecast.Forecast){
            with(forecast){
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener { itemClick(this) }


            }
        }
    }
}