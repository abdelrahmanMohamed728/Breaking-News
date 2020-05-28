package com.example.breakingnews.view.home.headlines


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.breakingnews.R
import com.example.breakingnews.base.BaseFragment
import com.example.breakingnews.model.Article
import com.example.breakingnews.view.home.headlines.adapter.HeadlineAdapter
import kotlinx.android.synthetic.main.fragment_headlines.*
import org.koin.android.ext.android.get

class HeadlinesFragment : BaseFragment() {
    lateinit var viewModel: HeadlinesViewModel
    lateinit var headlinesAdapter: HeadlineAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_headlines, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRecycler()
        initObservers()
    }

    private fun initRecycler() {
        viewModel.getHeadlines()
        headlinesAdapter =
            HeadlineAdapter(
                context!!,
                listOf()
            )
        topHeadlinesRV.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        topHeadlinesRV.adapter = headlinesAdapter
    }

    private fun initObservers() {
        viewModel.headlinesLiveData.observe(this, Observer {
            updateAdapter(it)
        })
    }

    private fun updateAdapter(articles: List<Article>) {
        headlinesAdapter.headlines = articles
        headlinesAdapter.notifyDataSetChanged()
    }

    private fun initViewModel() {
        viewModel = get()
    }
}
