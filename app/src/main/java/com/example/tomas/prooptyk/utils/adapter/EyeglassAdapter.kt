package com.example.tomas.prooptyk.utils.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tomas.prooptyk.R
import com.example.tomas.prooptyk.model.Eyeglass
import com.example.tomas.prooptyk.screen.main.fragment.EyeglassFragment

class EyeglassAdapter( context: Context) : RecyclerView.Adapter<EyeglassViewHolder>() {

//    private val onEyeglassItemClickListener = listener
    private val context = context

    private var mEyeglassList : ArrayList<Eyeglass>? = null

    fun setEyeglassList(eyeglassList: ArrayList<Eyeglass>?) {
        mEyeglassList = eyeglassList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EyeglassViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.eyeglass_item, parent, false)

//        view.setOnClickListener { object : OnEyeglassItemClickListener {
//            override fun onItemClicked(pos: Int) {
//                Log.e("clicked" , "item clicjed")
//            }
//        }
//        }
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

        holder.salon.setOnClickListener { Toast.makeText(context, "on salon clicked", Toast.LENGTH_SHORT).show() }

//        holder.item.setOnClickListener( object : OnEyeglassItemClickListener, View.OnClickListener {
//            override fun onClick(v: View?) {
//                Log.e("clicked" , "item clicjed")
//            }
//
//            override fun onItemClicked(pos: Int) {
//                Log.e("clicked" , "item clicjed")
//            }
//        })
    }
}