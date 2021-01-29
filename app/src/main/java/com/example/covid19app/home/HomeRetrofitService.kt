package com.example.covid19app.home

import com.example.covid19app.home.models.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeRetrofitService {
    @GET("/korea/")
    fun getCoivid(@Query("serviceKey") serviceKey: String): Call<HomeResponse>
}