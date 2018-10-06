package com.example.tomas.prooptyk.utils.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.tomas.prooptyk.R

class EyeglassViewHolder(var layout: View) : RecyclerView.ViewHolder(layout) {

    var holderName: TextView = layout.findViewById(R.id.holderName)
    var color : TextView = layout.findViewById(R.id.color)
}