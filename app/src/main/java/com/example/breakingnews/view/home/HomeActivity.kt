package com.example.breakingnews.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.example.breakingnews.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setTabBar()
    }

    private fun setTabBar() {
        val homeAdapter = HomeViewPagerAdapter(this)
        homeViewPager.adapter = homeAdapter
        TabLayoutMediator(homeTabBar, homeViewPager) { tab, position ->
            tab.text = "Top Headlines"
        }.attach()
    }
}
