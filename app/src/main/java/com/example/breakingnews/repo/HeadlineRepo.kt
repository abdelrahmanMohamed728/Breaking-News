package com.example.breakingnews.repo

import com.example.breakingnews.model.HeadlineResponse
import com.example.breakingnews.repo.api.WebService
import org.koin.core.context.GlobalContext
import io.reactivex.Observable
import org.koin.core.qualifier.named

class HeadlineRepo {

    fun getHeadlines() : Observable<HeadlineResponse>{
        var apiManager = GlobalContext.get().koin.get<WebService>()
        return apiManager.getHeadlines(COUNTRY,AppRepo.API_KEY)
    }

    companion object{
        const val COUNTRY = "us"
    }
}