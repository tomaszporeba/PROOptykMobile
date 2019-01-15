package com.example.tomas.prooptyk.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.example.tomas.prooptyk.screen.eyeglass.EyeglassActivityViewModel
import com.example.tomas.prooptyk.screen.login.LoginActivityViewModel
import com.example.tomas.prooptyk.screen.main.MainActivityViewModel
import com.example.tomas.prooptyk.screen.main.fragment.EyeglassFragmentViewModel
import com.example.tomas.prooptyk.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class ViewModelFactory @Inject
constructor(
        private val creators: Map<Class<out ViewModel>,
                @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                Log.e("error", "log")
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class " + modelClass)
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}


@Module
abstract class ViewModelModule {


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory):
            ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginActivityViewModel::class)
    abstract fun bindLoginActivityViewModel(loginViewModel: LoginActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EyeglassFragmentViewModel::class)
    abstract fun bindEyeglassFragmentViewModel(eyeglassViewModel: EyeglassFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EyeglassActivityViewModel::class)
    abstract fun bindEyeglassActivityViewModel(eyeglassActivityViewModel: EyeglassActivityViewModel): ViewModel


}
