package com.example.tomas.prooptyk.screen.main.fragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.tomas.prooptyk.model.Eyeglass
import javax.inject.Inject

class EyeglassFragmentViewModel @Inject constructor() : ViewModel() {

    var mutableEyeglassArray = MutableLiveData<ArrayList<Eyeglass>>()
    var eyeglassArray = ArrayList<Eyeglass>()
    fun getEyeglassList(): MutableLiveData<ArrayList<Eyeglass>> {
        for (i in 1..10) {

            var eyeglass = Eyeglass(i, "Rayban" + i, 10.0, 20.0, "23", 5, "red", "Piwniczna")
            eyeglassArray!!.add(eyeglass)
        }

        mutableEyeglassArray.value = eyeglassArray

        return mutableEyeglassArray
    }
}