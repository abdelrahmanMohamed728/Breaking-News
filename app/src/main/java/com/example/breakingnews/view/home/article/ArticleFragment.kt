package com.example.breakingnews.view.home.article


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.breakingnews.R
import com.example.breakingnews.base.BaseFragment
import com.example.breakingnews.model.Article
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : BaseFragment<ArticleViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.extractArguments(arguments!!)
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.articleLiveData.observe(this , Observer {
            showSnackBar(view!!,it.title)
        })
    }
}
