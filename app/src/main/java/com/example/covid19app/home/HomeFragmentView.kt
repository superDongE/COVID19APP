package com.example.covid19app.home

import com.example.covid19app.home.models.HomeResponse

interface HomeFragmentView {

    fun onGetCovidSuccess(response: HomeResponse)

    fun onGetCoivdFailure(message: String)
}