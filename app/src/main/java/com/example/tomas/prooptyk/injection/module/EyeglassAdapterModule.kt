package com.example.tomas.prooptyk.injection.module

import android.app.Application
import com.example.tomas.prooptyk.utils.adapter.EyeglassAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EyeglassAdapterModule {

    @Provides
    fun provideEyeglassAdapter(): EyeglassAdapter {
        return EyeglassAdapter()
    }


}