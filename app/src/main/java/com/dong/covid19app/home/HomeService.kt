package com.dong.covid19app.home

import com.dong.covid19app.config.ApplicationClass
import com.dong.covid19app.home.models.HomeResponse
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

class HomeService(val view: HomeFragmentView) {
    fun tryGetCovid(serviceKey : String){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitService::class.java)
        homeRetrofitInterface.getCoivid(serviceKey).enqueue(object: Callback<HomeResponse>{
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                view.onGetCovidSuccess(response.body() as HomeResponse)
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                view.onGetCoivdFailure(t.message ?: "통신오류")
            }

        })
    }
}