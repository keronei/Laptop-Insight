package com.keronei.android.repository

import com.keronei.android.data.repository.RemoteArticlesDataSource
import com.keronei.android.domain.models.Article
import com.keronei.android.domain.repositories.ArticlesRepository
import com.keronei.android.local.dao.article.ArticleDao
import com.keronei.android.local.entities.ArticleEntity
import com.keronei.android.mapper.toEntity
import com.keronei.android.mapper.toLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.xmlpull.v1.XmlPullParser
import timber.log.Timber

class ArticlesRepositoryImpl(
    private val articleDao: ArticleDao,
    private val remoteArticlesDataSource: RemoteArticlesDataSource,
    private val parser: XmlPullParser
) : ArticlesRepository {
    override fun fetchArticles(): Flow<List<Article>> = flow {
        val articles = mutableListOf<Article>()

        val receivedArticles = mutableListOf<ArticleEntity>()

        val freshArticles = remoteArticlesDataSource.fetchRemoteArticles(parser).first()

        Timber.d("Received articles from remote fetcher = ${freshArticles.size}")

        freshArticles.forEach { article ->
            receivedArticles.add(article.toEntity())
        }

        articleDao.insertArticle(receivedArticles)

        //remove old articles
        articleDao.cleanUpArticles()

        val cachedArticles = articleDao.getArticles().map { articlesInFlow ->
            articlesInFlow.map {
                it.toLocal()
            }
        }

        emit(cachedArticles.first())
    }

}