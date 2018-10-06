package com.example.tomas.prooptyk.screen.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
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
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_eyeglasses -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_clients -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_examinations -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_invoices -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
