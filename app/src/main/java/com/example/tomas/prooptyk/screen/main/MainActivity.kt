package com.example.tomas.prooptyk.screen.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.tomas.prooptyk.R
import com.example.tomas.prooptyk.databinding.ActivityMainBinding
import com.example.tomas.prooptyk.screen.main.fragment.EyeglassFragment
import com.example.tomas.prooptyk.utils.adapter.EyeglassAdapter
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    lateinit var binding : ActivityMainBinding

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        AndroidInjection.inject(this)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel

        val toolbar: Toolbar = findViewById(R.id.toolbar)


        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val eyeglassFragment = EyeglassFragment.newInstance()
        openFragment(eyeglassFragment)


    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_eyeglasses -> {

                val eyeglassFragment = EyeglassFragment.newInstance()
                openFragment(eyeglassFragment)
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

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
