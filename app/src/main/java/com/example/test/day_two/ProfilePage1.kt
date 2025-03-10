package com.example.test.day_two

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test.R

class ProfilePage1 : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var email:EditText
    private lateinit var dob:EditText
    private lateinit var previousBtn:Button
    private lateinit var nextBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profilepage1)
        //find id
        name=findViewById(R.id.name)
        email=findViewById(R.id.email)
        dob=findViewById(R.id.dob)
        previousBtn=findViewById(R.id.locB1)
        nextBtn=findViewById(R.id.locB2)
        val url="https://strengthen-numbers-stag.dev-imaginovation.net/api"


    }
}