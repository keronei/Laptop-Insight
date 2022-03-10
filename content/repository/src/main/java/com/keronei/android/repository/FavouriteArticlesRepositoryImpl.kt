package com.keronei.android.repository

import com.keronei.android.domain.models.Article
import com.keronei.android.domain.repositories.FavouriteArticlesRepository
import com.keronei.android.local.dao.article.FavouritesDao
import com.keronei.android.mapper.toEntity
import com.keronei.android.mapper.toLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavouriteArticlesRepositoryImpl(private val favouritesDao: FavouritesDao) :
    FavouriteArticlesRepository {

    override fun fetchFavouriteArticles(): Flow<List<Article>> = flow {
        val articles = mutableListOf<Article>()

        favouritesDao.getFavouriteArticles().forEach { articlesInFlow ->
            articles.add(articlesInFlow.toLocal())
        }

        emit(articles)
    }


    override suspend fun addFavouriteArticles(article: Article) {
        favouritesDao.insertFavouriteArticle(article.toEntity())
    }

    override suspend fun removeFavouriteArticles(article: Article) {
        favouritesDao.removeFromFavourite(article.id)
    }

}