package com.example.breakingnews.repo

import com.example.breakingnews.model.HeadlineResponse
import com.example.breakingnews.repo.api.WebService
import org.koin.core.context.GlobalContext
import io.reactivex.Observable

class HeadlineRepo {

    fun getHeadlines() : Observable<HeadlineResponse>{
        var apiManager = GlobalContext.get().koin.get<WebService>()
        return apiManager.getHeadlines()
    }
}