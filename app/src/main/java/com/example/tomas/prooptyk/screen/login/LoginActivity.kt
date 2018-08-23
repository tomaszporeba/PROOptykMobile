package com.example.tomas.prooptyk.screen.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tomas.prooptyk.R
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var loginActivityViewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
