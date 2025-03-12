package com.example.test

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test.model.APIDataClassOTP
import com.example.test.model.ObjectRetrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class OTP_Verification : AppCompatActivity() {
    private lateinit var otpTV1:TextView
    private lateinit var otpTV2:TextView
    private lateinit var otpTV3:TextView
    private lateinit var otpTV4:TextView
    private lateinit var otpTV5:TextView
    private lateinit var otpBtn1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)
        otpTV1=findViewById(R.id.otpTV1)
        otpTV2=findViewById(R.id.otpTV2)
        otpTV3=findViewById(R.id.otpTV3)
        otpTV4=findViewById(R.id.otpTV4)
        otpTV5=findViewById(R.id.otpTV5)
        otpBtn1=findViewById(R.id.otpBtn1)

        val mo_no = intent.extras?.getString("contactNumber")
        otpTV2.text="We have sent the verification code to your $mo_no mobile number."

        otpBtn1.setOnClickListener {
            verifyOTP(mo_no.toString(),otpTV3.text.toString().toInt())
        }

//        CoroutineScope(Dispatchers.Default).launch{
//            for (i in 30 downTo 1){
//                val res= otpTV4.setText("Did't recevied OTP? $i:00")
//                withContext(Dispatchers.Main) {
//                    otpTV4.setText(res.toString())
//                }
//                delay(1000)
//            }
//        }
    }

    private fun verifyOTP(mo_no:String,otp:Int){
        val objRetrofit = ObjectRetrofit(this)
            .getAPIService()
            .verifyOTP(mo_no, otp)
        objRetrofit?.enqueue(object : Callback<APIDataClassOTP> {
            override fun onResponse(
                call: Call<APIDataClassOTP>,
                response: Response<APIDataClassOTP>
            ) {
                Log.d("ABC","${response.headers()}")
                try{
                    if (response.code()==200) {
                        var token=response.headers()["X-Authorization-Token"]
                        if (token != null) {
                            Log.d("ABC", "Extracted Token: $token")
                            saveTokenToPreferences(token)
                        } else {
                            Log.d("ABC", "Token not found in headers")
                        }

                        val moveDashboardPage = Intent(this@OTP_Verification, DashBoard::class.java)
                        moveDashboardPage.putExtra("data", response.body()!!.data as Serializable)
                        startActivity(moveDashboardPage)
                        finish()
                    }
                    else{
                        Toast.makeText(this@OTP_Verification,"Error Occurred: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }
                catch (e: Exception) {
                    Toast.makeText(this@OTP_Verification,"Error Occurred: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<APIDataClassOTP>, t: Throwable) {
                Toast.makeText(this@OTP_Verification,"Error Occurred: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun saveTokenToPreferences(token:String){
        val sharedPreferences = getSharedPreferences("token", MODE_PRIVATE)
        sharedPreferences.edit().putString("auth_token", token).apply()
    }
}