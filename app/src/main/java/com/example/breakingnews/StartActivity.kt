package com.example.breakingnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.breakingnews.view.splash.SplashFragment


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        setFragment()
    }

    private fun setFragment() {
        var fragment = SplashFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.StartActivityContainer, fragment)
        fragmentTransaction.commit()
    }
}
