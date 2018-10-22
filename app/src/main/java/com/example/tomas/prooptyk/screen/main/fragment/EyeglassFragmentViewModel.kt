package com.example.tomas.prooptyk.screen.main.fragment

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import com.example.tomas.prooptyk.model.Eyeglass
import com.example.tomas.prooptyk.model.User
import com.example.tomas.prooptyk.model.UserResponse
import com.example.tomas.prooptyk.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import javax.inject.Inject

class EyeglassFragmentViewModel @Inject constructor() : ViewModel() {


    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var application: Application

    var mutableEyeglassArray = MutableLiveData<ArrayList<Eyeglass>>()
    var eyeglassArray = ArrayList<Eyeglass>()
    fun getEyeglassList(): MutableLiveData<ArrayList<Eyeglass>> {

        val prefs: SharedPreferences = application.getSharedPreferences("com.example.tomas.prooptyk", AppCompatActivity.MODE_PRIVATE)
        val token = prefs.getString("accessToken", "a")

        apiService.getAllEyeglasses("Bearer $token")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = { val dupa: String },
                        onSuccess = { mutableEyeglassArray = getEyeglasses(it.code(), it.body()) }
                )


        return mutableEyeglassArray
    }

    private fun getEyeglasses(code: Int?, eyeglasses: ArrayList<Eyeglass>?): MutableLiveData<ArrayList<Eyeglass>> {

        when (code) {
            in 200..299 -> {
                try {
                    this.mutableEyeglassArray.value = eyeglasses
                } catch (exception : IOException) {
                }

            }
        }
        return mutableEyeglassArray
    }
}