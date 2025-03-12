package com.example.test.day_two.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test.day_two.fragments.ProfilePage1
import com.example.test.day_two.fragments.ProfilePage2
import com.example.test.day_two.fragments.ProfilePage3

class ProfileAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    private val fragList = listOf(ProfilePage1(),ProfilePage2(),ProfilePage3())

    override fun getItemCount(): Int {
        return fragList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragList[position]
    }
}