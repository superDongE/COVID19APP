package com.dong.covid19app.src

import android.os.Bundle
import com.dong.covid19app.R
import com.dong.covid19app.config.BaseActivity
import com.dong.covid19app.databinding.ActivityMainBinding
import com.dong.covid19app.home.HomeFragment
import com.dong.covid19app.local.LocalFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
                BottomNavigationView.OnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.menu_main_btm_nav_home -> {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.main_frm, HomeFragment())
                                    .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                        R.id.menu_main_btm_nav_local -> {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.main_frm, LocalFragment())
                                    .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                    false
                })
    }
}