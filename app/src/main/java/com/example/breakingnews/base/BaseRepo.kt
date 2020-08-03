package com.example.breakingnews.base

import com.example.breakingnews.repo.api.WebService
import org.koin.core.context.GlobalContext

open class BaseRepo {
    var apiManager = GlobalContext.get().koin.get<WebService>()
    companion object{
        const val API_KEY = "9565ca60c31241c28b04f9728c7775f9"
    }
}