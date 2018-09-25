package com.example.tomas.prooptyk.screen.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.tomas.prooptyk.R
import com.example.tomas.prooptyk.databinding.ActivityMainBinding
import com.example.tomas.prooptyk.utils.adapter.EyeglassAdapter
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    lateinit var binding : ActivityMainBinding

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    private var recyclerView : RecyclerView? = null

    @Inject
    lateinit var eyeglassAdapter : EyeglassAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        AndroidInjection.inject(this)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel

        recyclerView = findViewById(R.id.eyeglassRecyclerView)

        viewModel.getEyeglassList().observe(this, Observer { eyeglassArray ->
            eyeglassAdapter!!.setEyeglassList(eyeglassArray)
            recyclerView!!.layoutManager = LinearLayoutManager(this)
            recyclerView!!.adapter = eyeglassAdapter

        })

//        viewModel.getEyeglassList()




    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
