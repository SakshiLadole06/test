package com.example.test

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.test.day_three.HomePage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("flag", false)

//        startActivity(Intent(this,HomePage::class.java))

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLoggedIn) {
                startActivity(Intent(this@MainActivity, HomePage::class.java))
            } else {
                startActivity(Intent(this@MainActivity, Login::class.java))
            }
            finish()
        }, 3000)
    }
}
