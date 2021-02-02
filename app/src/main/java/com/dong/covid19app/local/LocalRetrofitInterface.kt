package com.dong.covid19app.local

import com.dong.covid19app.local.models.LocalCountyResponse
import com.dong.covid19app.local.models.LocalResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LocalRetrofitInterface {
    @GET("/korea/country/new/")
    fun getLocalCovid(@Query("serviceKey") serviceKey: String): Call<LocalResponse>
}