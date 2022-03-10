package com.keronei.android.data.api

import io.ktor.client.statement.*

interface ArticleApi {
    suspend fun fetchArticles(): HttpResponse
}