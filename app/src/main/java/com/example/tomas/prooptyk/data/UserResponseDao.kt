package com.example.tomas.prooptyk.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.media.session.MediaSession
import com.example.tomas.prooptyk.model.User

@Dao
abstract class UserResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: User?)

    @Update
    abstract fun update(user: User)

    @Delete
    abstract fun delete(user: User)

    @Query("SELECT * from user WHERE username LIKE :username limit 1")
    abstract fun getUserByUsername(username: String) : LiveData<User>



}