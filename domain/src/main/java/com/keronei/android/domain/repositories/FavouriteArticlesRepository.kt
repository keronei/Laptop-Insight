package com.keronei.android.domain.repositories

import com.keronei.android.domain.models.Article
import kotlinx.coroutines.flow.Flow


interface FavouriteArticlesRepository {
    fun fetchFavouriteArticles(): Flow<List<Article>>
    suspend fun addFavouriteArticles(article: Article)
    suspend fun removeFavouriteArticles(article: Article)
}