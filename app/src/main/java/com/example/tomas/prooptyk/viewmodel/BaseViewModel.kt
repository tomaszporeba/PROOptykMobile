//package com.example.tomas.prooptyk.viewmodel
//
//import android.arch.lifecycle.ViewModel
//import com.example.tomas.prooptyk.injection.component.DaggerViewModelInjector
//import com.example.tomas.prooptyk.injection.component.ViewModelInjector
//import com.example.tomas.prooptyk.injection.module.AppModule
//import com.example.tomas.prooptyk.screen.login.LoginActivityViewModel
//import javax.inject.Inject
//
///**
// * Created by tomas on 13.08.2018.
// */
//abstract class BaseViewModel: ViewModel() {
//
////    @Inject
////    lateinit var appModule: AppModule
//
//    private val injector: ViewModelInjector = DaggerViewModelInjector
//            .builder()
//            .appModule(appModule)
//            .build()
//
//    init {
//        inject()
//    }
//
//    private fun inject() {
//        when(this) {
//            is LoginActivityViewModel -> injector.inject(this)
//        }
//    }
//
//
//
////    private fun inject() {
////        when(this) {
////            is LoginActivityViewModel -> injector.inject(this)
////        }
////    }
//}