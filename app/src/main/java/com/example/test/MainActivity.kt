package com.example.test

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("flag", false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLoggedIn) {
                startActivity(Intent(this@MainActivity, DashBoard::class.java))
            } else {
                startActivity(Intent(this@MainActivity, Login::class.java))
            }
            finish() // Close the splash screen
        }, 3000) // Delay for 3 seconds (splash screen effect)
    }
}
