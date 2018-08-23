package com.example.tomas.prooptyk.network

import android.webkit.WebChromeClient
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by tomas on 13.08.2018.
 */
interface ApiService {

    @POST("/login")
    fun login(@Body params: RequestBody)
}