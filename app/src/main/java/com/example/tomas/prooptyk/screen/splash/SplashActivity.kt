package com.example.tomas.prooptyk.screen.splash

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tomas.prooptyk.screen.login.LoginActivity
import com.example.tomas.prooptyk.screen.main.MainActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        doAsync {
            val prefs: SharedPreferences = getSharedPreferences("com.example.tomas.prooptyk", MODE_PRIVATE)
            val isLogged=prefs.getBoolean("isLogged", false)

            uiThread {
                if (isLogged){
                    startActivity<MainActivity>()
                }
                else startActivity<LoginActivity>()
                finish()
            }
        }

    }
}
