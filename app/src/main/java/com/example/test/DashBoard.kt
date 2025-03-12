package com.example.test

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.test.model.Data

class DashBoard : AppCompatActivity() {
    private lateinit var img: ImageView
    private lateinit var userName: TextView
    private lateinit var bio: TextView
    private lateinit var interest1: TextView
    private lateinit var interest2: TextView
    private lateinit var interest3: TextView
    private lateinit var followers: TextView
    private lateinit var followings: TextView
    private lateinit var logoutBtn: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        // Initialize views
        img = findViewById(R.id.dashIp1)
        userName = findViewById(R.id.dashIp2_txt_user_name)
        bio = findViewById(R.id.dashIp3_txt_user_bio)
        interest1 = findViewById(R.id.txt_interest1)
        interest2 = findViewById(R.id.txt_interest2)
        interest3 = findViewById(R.id.txt_interest3)
        followers = findViewById(R.id.dashIp5_txt_followers)
        followings = findViewById(R.id.dashIp6_txt_following)
        logoutBtn = findViewById(R.id.logoutBtn)

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)

        val arguments: Data? = intent.getSerializableExtra("data") as? Data

        if (arguments != null) {
            sharedPreferences.edit().apply {
                putBoolean("isLogIn", true)
                putString("txtUserName", arguments.name)
                putString("txtUserBio", arguments.bio)
                putString("profilePhoto", arguments.profile_photo)
                putString("total_followers", arguments.total_followers.toString())
                putString("total_followings", arguments.total_followings.toString())
                putString("txtInterest1", arguments.interests?.getOrNull(0) ?: "")
                putString("txtInterest2", arguments.interests?.getOrNull(1) ?: "")
                putString("txtInterest3", arguments.interests?.getOrNull(2) ?: "")
                putBoolean("flag", true)
                apply()
            }
        }

        userName.text = sharedPreferences.getString("txtUserName", "N/A")
        bio.text = sharedPreferences.getString("txtUserBio", "N/A")
        followers.text = sharedPreferences.getString("total_followers", "0")
        followings.text = sharedPreferences.getString("total_followings", "0")
        interest1.text = sharedPreferences.getString("txtInterest1", "-")
        interest2.text = sharedPreferences.getString("txtInterest2", "-")
        interest3.text = sharedPreferences.getString("txtInterest3", "-")

        val profilePhotoUrl = sharedPreferences.getString("profilePhoto", null)
        if (!profilePhotoUrl.isNullOrEmpty()) {
            Glide.with(this).load(profilePhotoUrl).into(img)
        }

        logoutBtn.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            sharedPreferences.edit().putBoolean("flag", false).apply()
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }
}
