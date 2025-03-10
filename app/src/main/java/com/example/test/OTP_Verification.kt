package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test.day_two.LocationPage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OTP_Verification : AppCompatActivity() {
    private lateinit var otpTV1:TextView
    private lateinit var otpTV2:TextView
    private lateinit var otpTV3:TextView
    private lateinit var otpTV4:TextView
    private lateinit var otpTV5:TextView
    private lateinit var otpBtn1:Button
    val url="https://strengthen-numbers-stag.dev-imaginovation.net/api/v2/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)
        otpTV1=findViewById(R.id.otpTV1)
        otpTV2=findViewById(R.id.otpTV2)
        otpTV3=findViewById(R.id.otpTV3)
        otpTV4=findViewById(R.id.otpTV4)
        otpTV5=findViewById(R.id.otpTV5)
        otpBtn1=findViewById(R.id.otpBtn1)

        otpBtn1.setOnClickListener {
            verifyOTP("+19173777213",otpTV3.text.toString().toInt())
        }
        otpTV2.text="We have sent the verification code to your ${"+19173777213"} mobile number."
        val rf = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIClass::class.java)
    }
    private fun verifyOTP(mo_no:String,otp:Int){
        val RetroFitBuilder = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIClass::class.java)

        val objRetrofitGet = RetroFitBuilder.login(mo_no)

        objRetrofitGet?.enqueue(object : Callback<APIDataClassLogin> {
            override fun onResponse(
                call: Call<APIDataClassLogin>,
                response: Response<APIDataClassLogin>
            ) {
                try{
                    if (response.code()==200) {
                        val moveDashboardPage = Intent(this@OTP_Verification, LocationPage::class.java)
                        startActivity(moveDashboardPage)
                    }
                    else{
                        Toast.makeText(this@OTP_Verification,"Error Occurred: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }
                catch (e: Exception) {
                    Toast.makeText(this@OTP_Verification,"Error Occurred: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<APIDataClassLogin>, t: Throwable) {
                Toast.makeText(this@OTP_Verification,"Error Occurred: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}