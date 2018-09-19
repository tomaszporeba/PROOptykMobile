package com.example.tomas.prooptyk.model

import android.arch.persistence.room.*
import io.reactivex.annotations.NonNull


@Entity(tableName = "userResponse")
data class UserResponse(
        @NonNull
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int = 0,

        @Ignore
        var user: User? = null,

        @ColumnInfo(name = "access_token")
        var access_token: String? = ""

)