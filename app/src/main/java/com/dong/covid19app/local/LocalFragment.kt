package com.dong.covid19app.local


import android.os.Bundle
import android.util.Log
import android.view.View
import com.dong.covid19app.R
import com.dong.covid19app.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.dong.covid19app.config.BaseFragment
import com.dong.covid19app.databinding.FragmentLocalBinding
import com.dong.covid19app.local.models.LocalCountyResponse
import com.dong.covid19app.local.models.LocalResponse

class LocalFragment: BaseFragment<FragmentLocalBinding>(FragmentLocalBinding::bind, R.layout.fragment_local), LocalFragmentView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(this.context!!)
        LocalService(this).tryGetCounty(X_ACCESS_TOKEN)
    }

    override fun onGetLocalSuccess(response: LocalResponse) {
        dismissLoadingDialog()
        val list = response.
        val adapter = LocalRvAdapter(this.context!!, list)
        binding.localRecycler.adapter = adapter
    }

    override fun onGetLocalFailure(message: String) {
        dismissLoadingDialog()
        Log.d("1q2w3e4r", "${message}")
    }
}