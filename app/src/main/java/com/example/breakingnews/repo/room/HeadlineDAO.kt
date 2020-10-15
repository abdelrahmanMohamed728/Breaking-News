package com.example.breakingnews.repo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.breakingnews.model.Article
import io.reactivex.Completable
import io.reactivex.Observable


@Dao
interface HeadlineDAO {

    @Query("SELECT * from Article")
    fun getAllHeadlines() : Observable<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(article: Article) : Completable
}