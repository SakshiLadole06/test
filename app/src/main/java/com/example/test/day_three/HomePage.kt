package com.example.test.day_three

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.test.DashBoard
import com.example.test.R
import com.example.test.model.Data
import com.example.test.model.FeedDataClass

class HomePage : AppCompatActivity() {
    private lateinit var name: TextView
    private lateinit var userName: TextView
    private lateinit var imgFeed: ImageView
    private lateinit var imgPostFeed: ImageView
    private lateinit var txtLikeFeed: TextView
    private lateinit var txtCommentFeed: TextView
    private lateinit var txtDsrcpFeed: TextView
    private lateinit var dashBoardBtn: Button
//    private lateinit var feedRecycler: RecyclerView
    private lateinit var feedList:List<FeedDataClass>
    private lateinit var feedsp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        //find id
        name = findViewById(R.id.nameFeed)
        userName = findViewById(R.id.userNameFeed)
        imgFeed = findViewById(R.id.imgFeed)
        imgPostFeed = findViewById(R.id.imgPostFeed)
        txtLikeFeed = findViewById(R.id.txtLikeFeed)
        txtCommentFeed = findViewById(R.id.txtCommentFeed)
//        txtDsrcpFeed = findViewById(R.id.txtDscrpFeed)
//        feedRecycler = findViewById(R.id.feedRecyclerView)
        dashBoardBtn = findViewById(R.id.dashboardBtn)


        //to get data
        feedsp = getSharedPreferences("login", MODE_PRIVATE)
        val arguments: Data? = intent.getSerializableExtra("dataFeed") as? Data

        if (arguments != null) {
            feedsp.edit().apply {
                putBoolean("isLogIn", true)
                putString("txtUserName", arguments.name)
                putString("profilePhoto", arguments.profile_photo)
                putBoolean("flag",true)
                apply()
            }
        }

        name.text = "Hello "+feedsp.getString("txtUserName", "N/A")
        userName.text=feedsp.getString("txtUserName", "N/A")

        val profilePhotoUrl = feedsp.getString("profilePhoto", null)
        if (!profilePhotoUrl.isNullOrEmpty()) {
            Glide.with(this).load(profilePhotoUrl).into(imgFeed)
        }


        dashBoardBtn.setOnClickListener {
            startActivity(Intent(this, DashBoard::class.java))
        }
    }
}