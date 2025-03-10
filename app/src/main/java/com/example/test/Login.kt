package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Login : AppCompatActivity() {
    private lateinit var loginTV3:EditText
    private lateinit var loginBtn:Button
    val url="https://strengthen-numbers-stag.dev-imaginovation.net/api/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginTV3=findViewById(R.id.loginTV3)
        loginBtn=findViewById(R.id.loginBtn)

        loginBtn.setOnClickListener{
            doLogin("+1" + loginTV3.text.toString())
        }
    }

    private fun doLogin(mo_no:String) {
        val RetroFitBuilder = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIClass::class.java)

        val objRetrofitGet = RetroFitBuilder.login(mo_no)

        objRetrofitGet?.enqueue(object : Callback<APIDataClassLogin>{
            override fun onResponse(
                call: Call<APIDataClassLogin>,
                response: Response<APIDataClassLogin>
            ) {
                try{
                    if (response.code()==200) {
                        val moveOTPpage = Intent(this@Login, OTP_Verification::class.java)
                        moveOTPpage.putExtra("contactNumber", loginTV3.text.toString())
                        startActivity(moveOTPpage)
                    }
                    else{
                        Toast.makeText(this@Login,"Error Occurred: ${"A"+response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }
                catch (e: Exception) {
                    Toast.makeText(this@Login,"Error Occurred: ${"B"+e.message}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<APIDataClassLogin>, t: Throwable) {
                Toast.makeText(this@Login,"Error Occurred: ${"C"+t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}