package com.example.covid19app.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.covid19app.R
import com.example.covid19app.config.BaseFragment
import com.example.covid19app.databinding.FragmentHomeBinding
import com.example.covid19app.home.models.HomeResponse
import com.example.covid19app.config.ApplicationClass.Companion.X_ACCESS_TOKEN

class HomeFragment: BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home), HomeFragmentView{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(this.context!!)
        HomeService(this).tryGetCovid(X_ACCESS_TOKEN)
    }

    override fun onGetCovidSuccess(response: HomeResponse) {
        dismissLoadingDialog()
    }

    override fun onGetCoivdFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast(message)
    }
}