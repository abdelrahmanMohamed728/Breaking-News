package com.example.breakingnews.repo.repos

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.example.breakingnews.base.BaseRepo
import com.example.breakingnews.model.Article
import com.example.breakingnews.model.HeadlineResponse
import com.example.breakingnews.repo.room.AppDatabase
import io.reactivex.Completable
import io.reactivex.Observable

class HeadlineRepo : BaseRepo() {

    fun getHeadlines(): Observable<HeadlineResponse> {
        return apiManager.getHeadlines(COUNTRY, API_KEY)
    }

    fun addArticles(articles: List<Article>): Completable {
        return Completable.concat(articles.map { article -> addHeadlineToDB(article) })
    }

   private  fun addHeadlineToDB(article: Article): Completable {
        return AppDatabase.database?.headlineDAO()?.insert(article)!!
    }

    fun getHeadlinesFromDB(): Observable<List<Article>> {
        return AppDatabase.database!!.headlineDAO().getAllHeadlines()
    }

    companion object {
        const val COUNTRY = "us"
    }
}