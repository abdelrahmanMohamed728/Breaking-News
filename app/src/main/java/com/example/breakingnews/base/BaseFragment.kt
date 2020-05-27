package com.example.breakingnews.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    fun addActivity(destActivity : AppCompatActivity){
        val intent = Intent(activity,destActivity::class.java)
        startActivity(intent)
    }
}