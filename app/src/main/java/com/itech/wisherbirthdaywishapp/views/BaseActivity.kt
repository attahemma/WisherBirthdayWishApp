package com.itech.wisherbirthdaywishapp.views


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.ActivityBaseBinding
import com.itech.wisherbirthdaywishapp.views.utils.BackPressedListener

class BaseActivity : AppCompatActivity(),BackPressedListener {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(
                R.id.nav_host_fragment_container
        ) as NavHostFragment
        binding.bottomNavContainerId.setupWithNavController(navController = navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener{ _, destination,_ ->
            when(destination.id){
                R.id.fragment_overview -> {

                    showNavBar()
                }
                R.id.fragment_upcoming_screen -> showNavBar()
                //R.id.backupFragment -> showNavBar()
                else -> binding.bottomNavContainerId.visibility = View.GONE
            }
        }
    }

    private fun showNavBar() {
        binding.bottomNavContainerId.visibility = View.VISIBLE

    }

    override fun onBackPressedFromFragment() {
        finish()
    }
}