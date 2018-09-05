package com.example.tomas.prooptyk.screen.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.ArrayMap
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
                val usr = userResponse as User
            }
        }

    }
}