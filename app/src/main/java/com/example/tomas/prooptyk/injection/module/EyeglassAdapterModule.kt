package com.example.tomas.prooptyk.injection.module

import android.content.Context
import com.example.tomas.prooptyk.screen.main.fragment.EyeglassFragment
import com.example.tomas.prooptyk.screen.main.fragment.injection.EyeglassFragmentModule
import com.example.tomas.prooptyk.utils.adapter.EyeglassAdapter
import com.example.tomas.prooptyk.utils.adapter.OnEyeglassItemClickListener
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module(includes = arrayOf(ContextModule::class))
class EyeglassAdapterModule {
//
//    @Inject
//    lateinit var eyeglassFragment: EyeglassFragment

    @Provides
    fun provideEyeglassAdapter(context: Context): EyeglassAdapter {
        return EyeglassAdapter(context)
    }

}