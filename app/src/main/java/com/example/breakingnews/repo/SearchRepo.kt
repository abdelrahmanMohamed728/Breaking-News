package com.example.breakingnews.repo

import com.example.breakingnews.base.BaseRepo
import com.example.breakingnews.model.SearchResponse
import io.reactivex.Observable

class SearchRepo : BaseRepo() {
    fun search(text : String) : Observable<SearchResponse>{
      return apiManager.search(text, API_KEY)
    }

}