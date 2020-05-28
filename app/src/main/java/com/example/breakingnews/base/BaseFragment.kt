package com.example.breakingnews.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.koin.android.ext.android.get
import org.koin.androidx.scope.currentScope
import org.koin.core.KoinComponent

open class BaseFragment : Fragment(){

    fun addActivity(destActivity : AppCompatActivity){
        val intent = Intent(activity,destActivity::class.java)
        startActivity(intent)
    }
}
