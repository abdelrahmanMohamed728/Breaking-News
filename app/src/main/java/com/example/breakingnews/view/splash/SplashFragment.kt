package com.example.breakingnews.view.splash


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.breakingnews.base.BaseFragment
import com.example.breakingnews.view.home.HomeActivity
import android.os.CountDownTimer
import androidx.lifecycle.Observer
import com.example.breakingnews.R


class SplashFragment : BaseFragment<SplashViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.addArticlesToDB()
        viewModel.successLiveData.observe(this, Observer {
            addActivity(HomeActivity())
            activity?.finishAffinity()
        })
    }
}
