package com.dong.covid19app.home

import com.dong.covid19app.home.models.HomeResponse

interface HomeFragmentView {

    fun onGetCovidSuccess(response: HomeResponse)

    fun onGetCoivdFailure(message: String)
}