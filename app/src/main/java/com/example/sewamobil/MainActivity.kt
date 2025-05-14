package com.example.sewamobil

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sewamobil.ui.WelcomeActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, WelcomeActivity::class.java))
        finish()
    }
}
