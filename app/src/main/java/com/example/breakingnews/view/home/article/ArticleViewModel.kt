package com.example.breakingnews.view.home.article

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.breakingnews.base.BaseViewModel
import com.example.breakingnews.model.Article

class ArticleViewModel : BaseViewModel() {
    var articleLiveData = MutableLiveData<Article>()

    fun extractArguments(bundle : Bundle){
         articleLiveData.value = bundle.getSerializable("article") as Article
    }
}