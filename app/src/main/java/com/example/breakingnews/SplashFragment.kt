package com.example.breakingnews


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.breakingnews.base.BaseFragment
import com.example.breakingnews.view.home.HomeActivity
import io.saeid.fabloading.LoadingView
import kotlinx.android.synthetic.main.fragment_splash.*
import android.os.CountDownTimer
import androidx.lifecycle.ViewModel


class SplashFragment : BaseFragment<ViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                addActivity(HomeActivity())
            }
        }.start()
    }
}
