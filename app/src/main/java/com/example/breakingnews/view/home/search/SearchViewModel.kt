package com.example.breakingnews.view.home.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.breakingnews.base.BaseViewModel
import com.example.breakingnews.model.Article
import com.example.breakingnews.repo.SearchRepo
import io.reactivex.schedulers.Schedulers

class SearchViewModel(var repo: SearchRepo) : BaseViewModel() {

    var searchResultsLiveData = MutableLiveData<List<Article>>()

    fun search(text: String) {
        var observable = repo.search(text)
            .subscribeOn(Schedulers.io())
            .doOnNext { searchResultsLiveData.postValue(it.articles) }

        mCompositeDisposable.add(
            observable.subscribe({ Log.d("myTag", "observable.subscribe") },
                { throwable ->
                    Log.d("myTag", "observable.throwable: $throwable")
                })
        )
    }
}