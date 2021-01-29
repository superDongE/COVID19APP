package com.example.covid19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covid19app.config.BaseActivity
import com.example.covid19app.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}