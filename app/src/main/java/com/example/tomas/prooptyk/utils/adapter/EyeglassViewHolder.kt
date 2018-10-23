package com.example.tomas.prooptyk.utils.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.tomas.prooptyk.R

class EyeglassViewHolder(var layout: View) : RecyclerView.ViewHolder(layout) {

    var salon: TextView = layout.findViewById(R.id.salon)
    var color : TextView = layout.findViewById(R.id.color)
}