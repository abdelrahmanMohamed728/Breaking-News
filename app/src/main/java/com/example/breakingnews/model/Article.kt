package com.example.breakingnews.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Article")
data class Article(
    val author: String? = null,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int =0
}