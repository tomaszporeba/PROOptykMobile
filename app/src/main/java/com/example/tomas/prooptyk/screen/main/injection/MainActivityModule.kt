package com.example.tomas.prooptyk.screen.main.injection

import com.example.tomas.prooptyk.screen.main.MainActivityViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by tomas on 13.08.2018.
 */
@Module
class MainActivityModule {

    @Provides
    fun provideViewModel() = MainActivityViewModel()

}