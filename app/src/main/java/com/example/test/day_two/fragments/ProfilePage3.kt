package com.example.test.day_two.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.day_two.adapter.GridViewAdapter
import com.example.test.model.GridModel


class ProfilePage3 : Fragment() {
    private lateinit var gridView: GridView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_page3, container, false)
        val context = requireContext() // Use requireContext() instead of container!!.context

        // Initialize GridView
        gridView = view.findViewById(R.id.gridView)
        val list = ArrayList<GridModel>()

        list.add(GridModel(R.drawable.gym, "Gym"))
        list.add(GridModel(R.drawable.yoga, "Yoga"))
        list.add(GridModel(R.drawable.cardio, "Cardio"))
        list.add(GridModel(R.drawable.home_workout, "Workout"))
        list.add(GridModel(R.drawable.cycling, "Cycling"))
        list.add(GridModel(R.drawable.zumba, "Zumba"))
        list.add(GridModel(R.drawable.diet, "Dieting"))
        list.add(GridModel(R.drawable.sports, "Sports"))
        list.add(GridModel(R.drawable.running, "Running"))

        val gridAdapter = GridViewAdapter(context, list)
        gridView.adapter = gridAdapter

        return view
    }
}