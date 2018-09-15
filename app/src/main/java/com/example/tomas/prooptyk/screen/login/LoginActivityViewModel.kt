package com.example.tomas.prooptyk.screen.login

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.util.ArrayMap
import com.example.tomas.prooptyk.injection.module.ViewModelFactory
import com.example.tomas.prooptyk.model.User
import com.example.tomas.prooptyk.model.UserResponse
import com.example.tomas.prooptyk.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody
import org.json.JSONObject
import javax.inject.Inject

class LoginActivityViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var application: Application

    fun loginButtonListener() {
        val jsonParams = ArrayMap<String, String>()
        jsonParams.put("username", "marios")
        jsonParams.put("password", "password")
        val json = JSONObject(jsonParams).toString()
        val body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json)
        apiService.login(body)
                .subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = { val dupa: String},
                        onSuccess = { login(it.code(), it.body())}
                )
    }

    private fun login(code: Int?, userResponse: UserResponse?) {

        when(code) {
            in 200 .. 299 -> {
                val prefs: SharedPreferences = application.getSharedPreferences("com.example.tomas.prooptyk", AppCompatActivity.MODE_PRIVATE)
                prefs.edit().putBoolean("isLogged", true)

            }
        }

    }
}