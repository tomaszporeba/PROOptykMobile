package com.example.tomas.prooptyk.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.media.session.MediaSession
import com.example.tomas.prooptyk.model.User
import com.example.tomas.prooptyk.model.UserResponse


@Dao
interface UserResponseDao {

    @Insert
    fun insertAll(userResponses: List<UserResponse>)

    @Update
    fun update(userResponse : UserResponse)

    @Delete
    fun delete(userResponse: UserResponse)

    @Query("SELECT * from userResponse")
    fun getUserResponses() : LiveData<List<UserResponse>>

    @Query("SELECT * from userResponse WHERE access_token= :token limit 1")
    fun getUserResponseByToken(token: String) : LiveData<UserResponse>

    @Query("SELECT * from user WHERE username LIKE :username limit 1")
    fun getUserByUsername(username: String) : LiveData<User>
}