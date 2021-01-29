package com.example.covid19app.home

import android.os.Bundle
import android.view.View
import com.example.covid19app.R
import com.example.covid19app.config.BaseFragment
import com.example.covid19app.databinding.FragmentHomeBinding

class HomeFragment: BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}