package com.example.tomas.prooptyk.screen.main.fragment.injection

import com.example.tomas.prooptyk.screen.main.fragment.EyeglassFragmentViewModel
import dagger.Module
import dagger.Provides


@Module
class EyeglassFragmentModule {

    @Provides
    fun provideViewModel() = EyeglassFragmentViewModel()
}