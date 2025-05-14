package com.example.sewamobil.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sewamobil.databinding.ActivityWelcomeBinding
import com.example.sewamobil.MainActivity
import com.example.sewamobil.R
import com.example.sewamobil.ui.auth.LoginActivity
import com.example.sewamobil.ui.auth.RegisterActivity
import com.example.sewamobil.ui.welcome.adapter.SliderAdapter
import com.example.sewamobil.ui.welcome.model.SliderItem

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var adapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSlider()

        binding.btnGetStarted.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun setupSlider() {
        val sliderItems = listOf(
            SliderItem(R.drawable.car1, "Choose Your Dream Car"),
            SliderItem(R.drawable.car2, "Easy Booking with Flexible Options"),
            SliderItem(R.drawable.car3, "Drive Safely and Comfortably")
        )

        adapter = SliderAdapter(sliderItems)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }
}