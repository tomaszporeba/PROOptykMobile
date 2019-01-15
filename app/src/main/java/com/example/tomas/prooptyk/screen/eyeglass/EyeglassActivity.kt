package com.example.tomas.prooptyk.screen.eyeglass

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.Nullable
import com.example.tomas.prooptyk.R
import com.example.tomas.prooptyk.databinding.ActivityEyeglassBinding
import com.example.tomas.prooptyk.databinding.FragmentEyeglassBinding
import com.example.tomas.prooptyk.model.Eyeglass
import com.example.tomas.prooptyk.screen.login.LoginActivityViewModel
import com.example.tomas.prooptyk.screen.main.MainActivity
import com.example.tomas.prooptyk.screen.main.fragment.EyeglassFragmentViewModel
import dagger.android.AndroidInjection
import org.jetbrains.anko.intentFor
import javax.inject.Inject

class EyeglassActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    lateinit var binding: ActivityEyeglassBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_eyeglass)
        AndroidInjection.inject(this)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(EyeglassActivityViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.getEyeglassById()

        viewModel.getEyeglassObservable()?.observe(this, Observer<Eyeglass> { eyeglass -> adapter.setWords(t!!) })

    }


}
