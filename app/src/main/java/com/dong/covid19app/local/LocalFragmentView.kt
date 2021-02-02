package com.dong.covid19app.local

import com.dong.covid19app.local.models.LocalCountyResponse
import com.dong.covid19app.local.models.LocalResponse

interface LocalFragmentView {
    fun onGetLocalSuccess(reponse: LocalResponse)

    fun onGetLocalFailure(message: String)
}