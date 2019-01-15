package com.example.tomas.prooptyk.screen.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.tomas.prooptyk.R
import com.example.tomas.prooptyk.databinding.ActivityLoginBinding
import com.example.tomas.prooptyk.screen.main.MainActivity
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.intentFor
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        AndroidInjection.inject(this)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginActivityViewModel::class.java)
        binding.viewModel = viewModel


        viewModel.sendLoginRequest.observe(this, Observer {
            startActivity(intentFor<MainActivity>().setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
