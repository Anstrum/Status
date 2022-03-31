package com.aos.status

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aos.status.services.Navigation
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Navigation.init(supportFragmentManager, HomeFragment(), R.id.main_layout)
    }

    override fun onBackPressed() {
        Navigation.back()
    }
} 