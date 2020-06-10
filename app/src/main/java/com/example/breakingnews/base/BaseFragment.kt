package com.example.breakingnews.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.get
import org.koin.androidx.scope.currentScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.KoinComponent
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

open class BaseFragment<T : BaseViewModel > : Fragment(){
    val viewModel: T by lazy { getViewModel(viewModelClass()) }
    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<T> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<T>).kotlin
    }

    fun addActivity(destActivity : AppCompatActivity){
        val intent = Intent(activity,destActivity::class.java)
        startActivity(intent)
    }

    fun showSnackBar(view: View,message : String){
        Snackbar.make(view,message,Snackbar.LENGTH_LONG).show()
    }

}
