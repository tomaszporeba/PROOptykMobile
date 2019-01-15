package com.example.tomas.prooptyk.screen.eyeglass

import android.arch.lifecycle.ViewModel
import javax.inject.Inject
import android.arch.lifecycle.LiveData
import com.example.tomas.prooptyk.data.EyeglassDao
import com.example.tomas.prooptyk.model.Eyeglass


class EyeglassActivityViewModel @Inject constructor() : ViewModel() {

    private val eyeglassObservable: LiveData<Eyeglass>? = null

    private val eyeglass : LiveData<Eyeglass>? = null

    @Inject
    private val eyeglassDao : EyeglassDao? = null


    fun getEyeglassObservable(): LiveData<Eyeglass>? {
        return eyeglassObservable
    }

    fun getEyeglassById(id: Int?) : LiveData<Eyeglass>? {
        return eyeglassDao?.getEyeglassById(id)
    }



}