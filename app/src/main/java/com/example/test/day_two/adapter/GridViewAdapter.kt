package com.example.test.day_two.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.test.R
import com.example.test.day_two.fragments.ProfilePage3
import com.example.test.model.GridModel

class GridViewAdapter(var context: Context, val list: List<GridModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): GridModel? {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.card_item, parent, false)

        val model = getItem(position)
        val textView = view.findViewById<TextView>(R.id.text_view)
        val imageView = view.findViewById<ImageView>(R.id.image_view)

        textView.text = model?.name
        imageView.setImageResource(model?.image ?: R.mipmap.ic_launcher)

        return view
    }

}

