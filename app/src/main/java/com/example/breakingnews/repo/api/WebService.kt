package com.example.breakingnews.repo.api

import com.example.breakingnews.R
import com.example.breakingnews.model.HeadlineResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface WebService {

    @GET("top-headlines?country=us&apiKey=9565ca60c31241c28b04f9728c7775f9")
    fun getHeadlines() : Observable<HeadlineResponse>
}