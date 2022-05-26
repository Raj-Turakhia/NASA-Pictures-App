package com.nasa.pictureapp.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.nasa.pictureapp.ui.dashboard.DashboardActivity
import com.nasa.pictureapp.util.extension.startActivityFinish
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        lifecycleScope.launch {
            startActivityFinish<DashboardActivity> { }
        }
    }
}