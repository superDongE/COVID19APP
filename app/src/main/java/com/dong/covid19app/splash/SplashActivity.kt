package com.dong.covid19app.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dong.covid19app.config.BaseActivity
import com.dong.covid19app.databinding.ActivitySplashBinding
import com.dong.covid19app.src.MainActivity

class SplashActivity:BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1500)
    }
}