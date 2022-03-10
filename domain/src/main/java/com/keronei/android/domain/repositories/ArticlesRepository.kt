package com.keronei.android.domain.repositories

import com.keronei.android.domain.models.Article
import kotlinx.coroutines.flow.Flow


interface ArticlesRepository {
     fun fetchArticles(): Flow<List<Article>>
}