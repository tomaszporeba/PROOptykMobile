package com.example.tomas.prooptyk.screen.main

import android.os.Bundle
import com.example.tomas.prooptyk.R
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : DaggerActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    @Inject lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
