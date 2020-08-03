package com.example.breakingnews.model

data class SearchResponse (
    var articles : List<Article>,
    val status: String,
    val totalResults: Int
)