package com.itech.wisherbirthdaywishapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.ActivityBaseBinding
import com.itech.wisherbirthdaywishapp.views.utils.BackPressedListener

class BaseActivity : AppCompatActivity(),BackPressedListener{

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onBackPressedFromFragment() {
        finish()
    }


}