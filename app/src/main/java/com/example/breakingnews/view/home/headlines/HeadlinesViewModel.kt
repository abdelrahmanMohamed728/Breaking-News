package com.example.breakingnews.view.home.headlines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.breakingnews.model.Article
import com.example.breakingnews.repo.HeadlineRepo
import io.reactivex.schedulers.Schedulers

class HeadlinesViewModel(var repo: HeadlineRepo) : ViewModel() {

    var headlinesLiveData = MutableLiveData<List<Article>>()

    fun getHeadlines() {
      var observable =  repo.getHeadlines()
            .subscribeOn(Schedulers.io())
            .doOnNext { headlinesLiveData.postValue(it.articles) }

        observable?.subscribe({ Log.d("myTag", "observable.subscribe") },
            { throwable ->
                Log.d("myTag", "observable.throwable: $throwable")
            })
    }
}