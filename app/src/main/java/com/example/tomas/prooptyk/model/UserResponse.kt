package com.example.tomas.prooptyk.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import io.reactivex.annotations.NonNull


@Entity(tableName = "userResponse", foreignKeys = arrayOf(ForeignKey(entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("userId"),
        onDelete = ForeignKey.CASCADE)))
class UserResponse {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "userId")
    var userId: Int? = null

    @ColumnInfo(name = "access_token")
    var access_token: String = ""


}