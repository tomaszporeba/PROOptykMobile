package com.example.tomas.prooptyk.network

import com.example.tomas.prooptyk.model.UserResponse
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by tomas on 13.08.2018.
 */
interface ApiService {

    @POST("/login")
    fun login(@Body params: RequestBody): Single<Response<UserResponse>>
}