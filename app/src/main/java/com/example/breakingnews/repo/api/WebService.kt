package com.example.breakingnews.repo.api

import com.example.breakingnews.R
import com.example.breakingnews.model.HeadlineResponse
import com.example.breakingnews.model.SearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("top-headlines")
    fun getHeadlines(@Query("country") country : String ,@Query("apikey") apikey : String ) : Observable<HeadlineResponse>

    @GET("everything")
    fun search(@Query("q") text : String , @Query("apikey") apikey: String) : Observable<SearchResponse>
}