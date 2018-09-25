package com.example.tomas.prooptyk.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.reactivex.annotations.NonNull


@Entity(tableName = "eyeglass")
class Eyeglass(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        @ColumnInfo(name = "eyeglass")
        var Id : Int? = -1,

        var holderName : String? = "",

        var purchasePrice : Double? = -1.0,

        var clientPrice : Double? = -1.0,

        var vat : String? = "",

        var availability : Int? = -1,

        var color : String? = "",

        var salon: String? = "")