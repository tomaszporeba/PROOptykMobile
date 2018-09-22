package com.example.tomas.prooptyk.injection.component

import android.app.Application
import com.example.tomas.prooptyk.AndroidApp
import com.example.tomas.prooptyk.injection.module.ActivityBuilder
import com.example.tomas.prooptyk.injection.module.AppModule
import com.example.tomas.prooptyk.injection.module.ViewModelModule
import com.example.tomas.prooptyk.screen.login.LoginActivityViewModel
import com.example.tomas.prooptyk.screen.main.MainActivityViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton



/**
 * Created by tomas on 13.08.2018.
 */

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class, ViewModelModule::class))
interface AppComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance fun application(app: Application): Builder
        fun build(): AppComponent
        fun appModule(appModule: AppModule): Builder
    }
    fun inject(loginActivityViewModel: LoginActivityViewModel)
    fun inject(mainActivityViewModel: MainActivityViewModel)
    fun inject(app: AndroidApp)
}
