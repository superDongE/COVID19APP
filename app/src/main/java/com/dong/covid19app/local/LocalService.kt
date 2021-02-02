package com.dong.covid19app.local

import com.dong.covid19app.config.ApplicationClass
import com.dong.covid19app.local.models.LocalResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocalService(val view: LocalFragment) {

    fun tryGetCounty(serviceKey: String){
        val localRetrofitInterface = ApplicationClass.sRetrofit.create(LocalRetrofitInterface::class.java)
        localRetrofitInterface.getLocalCovid(serviceKey).enqueue(object : Callback<LocalResponse>{
            override fun onResponse(call: Call<LocalResponse>, response: Response<LocalResponse>) {
                view.onGetLocalSuccess(response.body() as LocalResponse)
            }

            override fun onFailure(call: Call<LocalResponse>, t: Throwable) {
                view.onGetLocalFailure(t.message ?: "통신오류")
            }
        })
    }
}