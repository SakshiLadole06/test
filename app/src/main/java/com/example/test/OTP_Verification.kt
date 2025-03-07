package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Retrofit

class OTP_Verification : AppCompatActivity() {
    private lateinit var otpTV1:TextView
    private lateinit var otpTV2:TextView
    private lateinit var otpTV3:TextView
    private lateinit var otpTV4:TextView
    private lateinit var otpTV5:TextView
    private lateinit var otpBtn1:Button

    val url="https://fakestoreapi.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)
        otpTV1=findViewById(R.id.otpTV1)
        otpTV2=findViewById(R.id.otpTV2)
        otpTV3=findViewById(R.id.otpTV3)
        otpTV4=findViewById(R.id.otpTV4)
        otpTV5=findViewById(R.id.otpTV5)
        otpBtn1=findViewById(R.id.otpBtn1)

        val rf=Retrofit.Builder()
            .addConverterFactory()
            .build()
            .create(APIClass::class.java)

        val
    }
}