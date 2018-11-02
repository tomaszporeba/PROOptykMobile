package com.example.tomas.prooptyk.data
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.tomas.prooptyk.model.Eyeglass
import android.arch.persistence.room.OnConflictStrategy



@Dao
abstract class EyeglassDao {

    @Insert
    abstract fun insert(eyeglass: Eyeglass?)

    @Update
    abstract fun update(eyeglass: Eyeglass?)

    @Delete
    abstract fun delete(eyeglass: Eyeglass?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertEyeglasses(eyeglassArrayList: ArrayList<Eyeglass>?)
//
//    @Query("SELECT * from eyeglass")
//    abstract fun getAllEyeglasses() : LiveData<ArrayList<Eyeglass>>
}