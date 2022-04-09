package com.keronei.android.laptopReview.ui.articles

import com.keronei.android.domain.models.Article
import com.keronei.android.domain.usecases.FetchArticlesBaseUseCase
import com.keronei.android.domain.usecases.FetchArticlesUseCase
import com.keronei.android.laptopReview.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import timber.log.Timber

class ArticlesViewModel(private val fetchArticlesUseCase: FetchArticlesUseCase) :
    BaseViewModel() {

    private var fetchAllArticlesJob: Job? = null

    private val articlesList = MutableStateFlow<List<Article>?>(null)

    val availableArticles : StateFlow<List<Article>?> = articlesList

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        // val result = exception.stackTrace

        exception.printStackTrace()
    }

    init {
        getArticles()

    }

    private fun getArticles() {
        fetchAllArticlesJob = launchCoroutine {
            fetchArticlesUseCase(Unit).collect { receivedArticles ->
                Timber.d("Received articles in viewModel -> ${receivedArticles.size}")
                articlesList.emit(receivedArticles)
            }
        }
    }

}