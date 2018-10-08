package com.example.tomas.prooptyk

import android.app.Activity
import android.app.Application
import android.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import com.example.tomas.prooptyk.injection.component.DaggerAppComponent
import com.example.tomas.prooptyk.injection.module.AppModule
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class AndroidApp: Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<android.support.v4.app.Fragment>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .appModule(AppModule())
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun supportFragmentInjector(): AndroidInjector<android.support.v4.app.Fragment> = fragmentInjector
}