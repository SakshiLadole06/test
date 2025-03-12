package com.example.test

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test.model.APIDataClassLogin
import com.example.test.model.ObjectRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    private lateinit var loginTV3:EditText
    private lateinit var loginBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginTV3=findViewById(R.id.loginTV3)
        loginBtn=findViewById(R.id.loginBtn)

        loginBtn.setOnClickListener{
            doLogin("+1" + loginTV3.text.toString())
//            doLogin("+19173777213")
        }
    }
    private fun doLogin(mo_no:String) {
        val objRetrofit = ObjectRetrofit(this)
            .getAPIService()
            .login(mo_no)
        objRetrofit?.enqueue(object : Callback<APIDataClassLogin>{
            override fun onResponse(
                call: Call<APIDataClassLogin>,
                response: Response<APIDataClassLogin>
            ) {
                try{
                    Log.d("ABC","${response.headers()}")
                    if (response.code()==200) {
                        Toast.makeText(this@Login,"Error Occurred: ${response.code()}", Toast.LENGTH_SHORT).show()
                        val moveOTPpage = Intent(this@Login, OTP_Verification::class.java)
                        moveOTPpage.putExtra("contactNumber", loginTV3.text.toString())
                        startActivity(moveOTPpage)
                    }
                    else{
                        Toast.makeText(this@Login,"Error Occurred: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }
                catch (e: Exception) {
                    Toast.makeText(this@Login,"Error Occurred: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<APIDataClassLogin>, t: Throwable) {
                Toast.makeText(this@Login,"Error Occurred: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}