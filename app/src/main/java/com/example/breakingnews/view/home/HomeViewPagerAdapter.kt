package com.example.breakingnews.view.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.breakingnews.view.home.headlines.HeadlinesFragment
import com.example.breakingnews.view.home.search.SearchFragment

class HomeViewPagerAdapter(activity: HomeActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return TOTAL_NUMBER
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == HEADLINE_FRAGMENT)
            HeadlinesFragment()
        else
            SearchFragment()

    }

    companion object {
        const val TOTAL_NUMBER = 2
        const val HEADLINE_FRAGMENT = 0
    }

}