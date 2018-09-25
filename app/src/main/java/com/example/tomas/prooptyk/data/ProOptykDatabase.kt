package com.example.tomas.prooptyk.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.tomas.prooptyk.model.Eyeglass
import com.example.tomas.prooptyk.model.User
import com.example.tomas.prooptyk.model.UserResponse


@Database(entities = arrayOf(User::class, Eyeglass::class), version = 1)
abstract class ProOptykDatabase : RoomDatabase() {

    abstract fun userResponseDao() : UserResponseDao
}