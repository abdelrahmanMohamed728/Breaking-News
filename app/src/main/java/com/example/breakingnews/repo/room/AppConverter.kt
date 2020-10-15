package com.example.breakingnews.repo.room

import androidx.room.TypeConverter
import com.example.breakingnews.base.ParserUtils
import com.example.breakingnews.model.Article
import com.example.breakingnews.model.Source
import com.google.gson.Gson

class AppConverter  {

    @TypeConverter
    fun fromListOfArticles(articlesJson: String?): Source? {
        return if (articlesJson == null) null else Gson().fromJson(articlesJson, Source::class.java)
    }
    @TypeConverter
    fun toListOfArticles(source: Source): String? {
        return if (source == null) null else Gson().toJson(source)
    }
}