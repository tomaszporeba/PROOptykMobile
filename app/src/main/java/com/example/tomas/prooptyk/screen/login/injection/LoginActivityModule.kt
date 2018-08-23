package com.example.tomas.prooptyk.screen.login.injection

import com.example.tomas.prooptyk.screen.login.LoginActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    fun provideViewModel() = LoginActivityViewModel()
}