package com.example.tomas.prooptyk.screen.main.fragment

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Dao
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import com.example.tomas.prooptyk.data.EyeglassDao
import com.example.tomas.prooptyk.model.Eyeglass
import com.example.tomas.prooptyk.model.User
import com.example.tomas.prooptyk.model.UserResponse
import com.example.tomas.prooptyk.network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import javax.inject.Inject

class EyeglassFragmentViewModel @Inject constructor() : ViewModel() {


    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var eyeglassDao: EyeglassDao

    private val compositeDisposable  = CompositeDisposable()

    var mutableEyeglassArray = MutableLiveData<ArrayList<Eyeglass>>()
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
                    this.insertEyeglassArray(eyeglasses)
                    this.mutableEyeglassArray.value = eyeglasses

                } catch (exception : IOException) {
                }

            }
        }
        return mutableEyeglassArray
    }

    private fun insertEyeglassArray(eyeglasses: ArrayList<Eyeglass>?) {
        compositeDisposable.add(Observable.fromCallable { eyeglassDao.insertEyeglasses(eyeglasses)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }
}