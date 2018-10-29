package com.example.tomas.prooptyk.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(context: Context) {

    var context = context

    @Provides
    fun context() : Context {
        return context
    }
}