package com.keronei.android.domain.usecases

import com.keronei.android.domain.models.Article
import com.keronei.android.domain.repositories.ArticlesRepository
import kotlinx.coroutines.flow.Flow

typealias FetchArticlesBaseUseCase = BaseUseCase<Unit, Flow<List<Article>>>

class FetchArticlesUseCase (private val articlesRepository: ArticlesRepository) : FetchArticlesBaseUseCase{
    override fun invoke(params: Unit): Flow<List<Article>> {
        return articlesRepository.fetchArticles()
    }

}