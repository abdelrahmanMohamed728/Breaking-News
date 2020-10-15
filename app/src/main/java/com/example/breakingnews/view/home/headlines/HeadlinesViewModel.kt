package com.example.breakingnews.view.home.headlines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.breakingnews.base.BaseViewModel
import com.example.breakingnews.model.Article
import com.example.breakingnews.repo.repos.HeadlineRepo
import io.reactivex.schedulers.Schedulers

class HeadlinesViewModel(private var repo: HeadlineRepo) : BaseViewModel() {

    var headlinesLiveData = MutableLiveData<List<Article>>()

    fun getHeadlines() {
      var observable =  repo.getHeadlinesFromDB()
            .subscribeOn(Schedulers.io())
            .doOnNext { headlinesLiveData.postValue(it) }

        mCompositeDisposable.add(observable.subscribe({ Log.d("myTag", "observable.subscribe") },
            { throwable ->
                Log.d("myTag", "observable.throwable: $throwable")
            }))
    }
}