package com.example.test.day_two

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.test.R
import com.example.test.day_two.adapter.GridViewAdapter
import com.example.test.day_two.adapter.ProfileAdapter
import com.example.test.model.GridModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfilePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabsLayout)

        val adapter = ProfileAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

        }.attach()
    }
}