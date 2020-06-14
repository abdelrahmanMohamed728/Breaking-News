package com.example.breakingnews.Koin_DI

import com.example.breakingnews.repo.HeadlineRepo
import com.example.breakingnews.repo.api.WebService
import com.example.breakingnews.view.home.article.ArticleViewModel
import com.example.breakingnews.view.home.headlines.HeadlinesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val viewModelsModule = module {
    viewModel { HeadlinesViewModel(get()) }
    viewModel { ArticleViewModel() }
}

val repoModule = module {

    factory(named("BASE_URL")) {
        "https://newsapi.org/v2/"
    }

    factory {
        Retrofit.Builder()
            .baseUrl(get<String>(named("BASE_URL")))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(WebService::class.java)
    }

    factory {
        HeadlineRepo()
    }
}