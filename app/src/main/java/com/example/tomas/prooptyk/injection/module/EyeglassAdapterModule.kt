package com.example.tomas.prooptyk.injection.module

import android.content.Context
import com.example.tomas.prooptyk.utils.adapter.EyeglassAdapter
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(ContextModule::class))
class EyeglassAdapterModule {

    @Provides
    fun provideEyeglassAdapter(context: Context): EyeglassAdapter {
        return EyeglassAdapter(context)
    }

}