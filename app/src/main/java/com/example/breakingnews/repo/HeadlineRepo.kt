package com.example.breakingnews.repo

import com.example.breakingnews.base.BaseRepo
import com.example.breakingnews.model.HeadlineResponse
import com.example.breakingnews.repo.api.WebService
import org.koin.core.context.GlobalContext
import io.reactivex.Observable
import org.koin.core.qualifier.named

class HeadlineRepo : BaseRepo(){

    fun getHeadlines() : Observable<HeadlineResponse>{
        return apiManager.getHeadlines(COUNTRY,API_KEY)
    }

    companion object{
        const val COUNTRY = "us"
    }
}