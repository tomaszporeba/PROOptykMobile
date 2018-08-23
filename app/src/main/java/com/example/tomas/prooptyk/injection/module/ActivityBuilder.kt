package com.example.tomas.prooptyk.injection.module

import com.example.tomas.prooptyk.screen.login.LoginActivity
import com.example.tomas.prooptyk.screen.login.injection.LoginActivityModule
import com.example.tomas.prooptyk.screen.main.MainActivity
import com.example.tomas.prooptyk.screen.main.injection.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tomas on 13.08.2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity():MainActivity

    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    abstract fun bindLoginActivity():LoginActivity
}