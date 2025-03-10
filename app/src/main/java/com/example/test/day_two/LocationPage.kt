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

        val arr= arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        //find id
        dontAllowBtn=findViewById(R.id.locB1)
        allowBtn=findViewById(R.id.locB2)

        dontAllowBtn.setOnClickListener {
            Log.d("ABC1","btn clicked")
            val profilepg=Intent(this@LocationPage,ProfilePage1::class.java)
            Log.d("ABC1","btn clicked......")
            startActivity(profilepg)
        }

        allowBtn.setOnClickListener {
            Log.d("ABC","btn clicked")
            val profilepg=Intent(this@LocationPage,ProfilePage1::class.java)
            Log.d("ABC","btn clicked......")
            requestPermissions(arr, RESULT_OK)
            startActivity(profilepg)
        }
    }
}