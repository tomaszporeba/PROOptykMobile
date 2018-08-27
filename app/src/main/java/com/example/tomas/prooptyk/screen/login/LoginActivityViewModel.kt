package com.example.tomas.prooptyk.screen.login

import android.arch.lifecycle.ViewModel
import android.util.ArrayMap
import com.example.tomas.prooptyk.network.ApiService
//import com.example.tomas.prooptyk.viewmodel.BaseViewModel
import org.json.JSONObject
import javax.inject.Inject

class LoginActivityViewModel @Inject constructor(): ViewModel() {

//    @Inject
//    lateinit var apiService: ApiService

    fun loginButtonListener() {
        val jsonParams = ArrayMap<String, String>()
        jsonParams.put("username", "marios")
        jsonParams.put("password", "password")
//        apiService.login(JSONObject(jsonParams))
    }
}