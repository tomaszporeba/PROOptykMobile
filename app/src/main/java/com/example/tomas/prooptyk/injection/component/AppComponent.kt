package com.example.tomas.prooptyk.injection.component

import android.app.Application
import com.example.tomas.prooptyk.AndroidApp
import com.example.tomas.prooptyk.injection.module.ActivityBuilder
import com.example.tomas.prooptyk.injection.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by tomas on 13.08.2018.
 */

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: AndroidApp)
}
