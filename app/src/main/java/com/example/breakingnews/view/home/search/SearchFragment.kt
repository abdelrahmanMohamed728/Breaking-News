package com.example.breakingnews.view.home.search


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.breakingnews.R
import com.example.breakingnews.base.BaseFragment
import com.example.breakingnews.base.OnClickItem
import com.example.breakingnews.model.Article
import com.example.breakingnews.view.home.article.ArticleFragment
import com.example.breakingnews.view.home.headlines.adapter.HeadlineAdapter
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment<SearchViewModel>(), OnClickItem {
    private lateinit var searchAdapter: HeadlineAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchSV.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty())
                    viewModel.search(newText)
                return false
            }

        })
    }

    override fun initObservers() {
        viewModel.searchResultsLiveData.observe(this , Observer {
            if (it.isNullOrEmpty()){
                noResultsTV.visibility = View.VISIBLE
                searchResultsRV.visibility = View.GONE
            }
            else{
                noResultsTV.visibility = View.GONE
                searchResultsRV.visibility = View.VISIBLE
                updateAdapter(it)
            }
        })
    }

    private fun updateAdapter(articles: List<Article>) {
        searchAdapter.headlines = articles
        searchAdapter.notifyDataSetChanged()
    }

    override fun initRecycler() {
        searchAdapter =
            HeadlineAdapter(
                context!!,
                listOf(),
                this
            )
        searchResultsRV.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        searchResultsRV.adapter = searchAdapter
    }

    override fun onItemClicked(position: Int) {
        var bundle = Bundle()
        if (!viewModel.searchResultsLiveData.value.isNullOrEmpty()) {
            bundle.putSerializable("article", viewModel.searchResultsLiveData.value!![position])
            addFragmentWithBundle(ArticleFragment(), bundle)
        } else
            addFragment(ArticleFragment())
    }


}
