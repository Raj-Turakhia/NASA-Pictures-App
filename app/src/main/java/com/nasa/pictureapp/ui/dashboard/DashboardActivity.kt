package com.nasa.pictureapp.ui.dashboard

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.nasa.pictureapp.R
import com.nasa.pictureapp.databinding.ActivityDashboardBinding
import com.nasa.pictureapp.di.base.BaseActivity

class DashboardActivity : BaseActivity<ActivityDashboardBinding>(R.layout.activity_dashboard) {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        navController = findNavController(R.id.nav_host_fragment)
    }
}