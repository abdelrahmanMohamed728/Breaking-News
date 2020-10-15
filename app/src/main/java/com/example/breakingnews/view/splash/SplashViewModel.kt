package com.example.breakingnews.view.splash

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.breakingnews.base.BaseViewModel
import com.example.breakingnews.model.HeadlineResponse
import com.example.breakingnews.repo.repos.HeadlineRepo
import com.example.breakingnews.view.home.HomeActivity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SplashViewModel(var repo: HeadlineRepo) : BaseViewModel() {

    var successLiveData = MutableLiveData<Boolean>()
    fun addArticlesToDB() {
        var observable = repo.getHeadlines()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { updateDB(it) }
            .subscribe({ Log.d("myTag", "observable.subscribe") },
                { throwable ->
                    Log.d("myTag", "observable.throwable: $throwable")
                })

        mCompositeDisposable.add(observable)
    }

    @SuppressLint("CheckResult")
    private fun updateDB(it: HeadlineResponse?) {
        var completable = repo.addArticles(it!!.articles)
            .subscribeOn(Schedulers.io())
            .doOnComplete { successLiveData.postValue(true) }
            .doOnError { Log.v("test", it.message) }
            .subscribe({ Log.d("myTag", "observable.subscribe") },
                { throwable ->
                    Log.d("myTag", "observable.throwable: $throwable")
                })
        mCompositeDisposable.add(completable)
    }

}