package com.example.breakingnews.koin_di

import com.example.breakingnews.repo.repos.HeadlineRepo
import com.example.breakingnews.repo.repos.SearchRepo
import com.example.breakingnews.repo.api.WebService
import com.example.breakingnews.view.home.article.ArticleViewModel
import com.example.breakingnews.view.home.headlines.HeadlinesViewModel
import com.example.breakingnews.view.home.search.SearchViewModel
import com.example.breakingnews.view.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val viewModelsModule = module {
    viewModel { HeadlinesViewModel(get()) }
    viewModel { ArticleViewModel() }
    viewModel { SearchViewModel(get()) }
    viewModel { SplashViewModel(get()) }
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

    factory {
        SearchRepo()
    }
}