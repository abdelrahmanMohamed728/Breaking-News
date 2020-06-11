package com.example.breakingnews.base

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    var container = -1

    fun setContainerView(int : Int){
        container = int
    }

}