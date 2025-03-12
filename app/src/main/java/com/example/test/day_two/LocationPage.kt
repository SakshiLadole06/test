package com.example.test.day_two

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test.R

class LocationPage : AppCompatActivity() {
    private lateinit var dontAllowBtn:Button
    private lateinit var allowBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_page)

        val profilepg=Intent(this@LocationPage,ProfilePageActivity::class.java)
        val arr= arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        //find id
        dontAllowBtn=findViewById(R.id.locB1)
        allowBtn=findViewById(R.id.locB2)

        dontAllowBtn.setOnClickListener {
            startActivity(profilepg)
        }

        allowBtn.setOnClickListener {
            requestPermissions(arr, 100)
            startActivity(profilepg)
        }
    }
}