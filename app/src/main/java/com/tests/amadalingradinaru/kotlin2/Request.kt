package com.tests.amadalingradinaru.kotlin2

import android.util.Log
import java.net.URL

/**
 * Created by a.madalin.gradinaru on 16/01/2018.
 */
class Request(val url: String) {
    fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)

    }
}