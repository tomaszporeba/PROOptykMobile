package com.example.tomas.prooptyk.injection.component

import android.app.Application
import com.example.tomas.prooptyk.injection.module.ViewModelModule
import com.example.tomas.prooptyk.screen.login.LoginActivityViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ViewModelModule::class
))
interface ViewModelComponent {

    @Component.Builder
    interface Builder {
        fun build(): ViewModelComponent
    }

    // inject your view models
    fun inject(loginActivityViewModel: LoginActivityViewModel)

}