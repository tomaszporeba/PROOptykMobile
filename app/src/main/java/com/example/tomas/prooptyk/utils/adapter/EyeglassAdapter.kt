package com.example.tomas.prooptyk.utils.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tomas.prooptyk.R
import com.example.tomas.prooptyk.model.Eyeglass

class EyeglassAdapter : RecyclerView.Adapter<EyeglassViewHolder>() {

    private var mEyeglassList : ArrayList<Eyeglass>? = null

    fun setEyeglassList(eyeglassList: ArrayList<Eyeglass>?) {
        mEyeglassList = eyeglassList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EyeglassViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.eyeglass_item, parent, false)

        return EyeglassViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mEyeglassList!!.size
    }

    override fun onBindViewHolder(holder: EyeglassViewHolder, position: Int) {

        val eyeglass = mEyeglassList?.get(position)
        val salon = eyeglass?.salon
        val color = eyeglass?.color
        holder.salon.text = salon
        holder.color.text = color
    }
}