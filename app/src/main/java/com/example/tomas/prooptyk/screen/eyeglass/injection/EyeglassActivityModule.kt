package com.example.tomas.prooptyk.screen.eyeglass.injection

import com.example.tomas.prooptyk.screen.eyeglass.EyeglassActivityViewModel
import dagger.Module
import dagger.Provides


@Module
class EyeglassActivityModule {

    @Provides
    fun provideViewModel()= EyeglassActivityViewModel()
}