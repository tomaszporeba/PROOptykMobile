package com.example.tomas.prooptyk.screen.login

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.util.ArrayMap
import android.util.Log
import com.example.tomas.prooptyk.data.UserResponseDao
import com.example.tomas.prooptyk.model.User
import com.example.tomas.prooptyk.model.UserResponse
import com.example.tomas.prooptyk.network.ApiService
import com.example.tomas.prooptyk.utils.SingleLiveEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject

class LoginActivityViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var userResponseDao: UserResponseDao

    val sendLoginRequest = SingleLiveEvent<Any?>()

    private val compositeDisposable  = CompositeDisposable()

    fun loginButtonListener() {
        val jsonParams = ArrayMap<String, String>()
        jsonParams.put("username", "marios")
        jsonParams.put("password", "password")
        val json = JSONObject(jsonParams).toString()
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json)
        apiService.login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = { val dupa: String },
                        onSuccess = { login(it.code(), it.body()) }
                )
    }

    private fun login(code: Int?, userResponse: UserResponse?) {

        when (code) {
            in 200..299 -> {
                    try {
                        val usr = userResponse?.user as User
                        insertUser(usr)
                    } catch (exception : IOException) {
                    }
                val prefs: SharedPreferences = application.getSharedPreferences("com.example.tomas.prooptyk", AppCompatActivity.MODE_PRIVATE)
                val editor = prefs.edit()
                editor.putString("accessToken", userResponse?.access_token)
                editor.putBoolean("isLogged", true)
                editor.commit()

                sendLoginRequest.call()

            }
        }
    }


    private fun getUser() {
        compositeDisposable.add(Observable.fromCallable {userResponseDao.getUserByUsername("marios")}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> onUserRetrieved(result)})
    }


    private fun insertUser(user : User) {

        compositeDisposable.add(Observable.fromCallable { userResponseDao.insert(user) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }

    private fun onUserRetrieved(user : LiveData<User>) {

        Log.i("User", "aaaa")
    }
}