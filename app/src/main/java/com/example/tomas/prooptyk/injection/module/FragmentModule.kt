package com.example.tomas.prooptyk.injection.module

import com.example.tomas.prooptyk.screen.main.fragment.EyeglassFragment
import com.example.tomas.prooptyk.screen.main.fragment.injection.EyeglassFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = arrayOf(EyeglassFragmentModule::class))
    abstract fun bindEyeglassFragment() : EyeglassFragment

}