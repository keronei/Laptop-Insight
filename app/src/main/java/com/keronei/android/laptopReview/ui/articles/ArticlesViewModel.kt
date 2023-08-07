package com.keronei.android.laptopReview.ui.articles

import androidx.lifecycle.SavedStateHandle
import com.keronei.android.domain.models.Article
import com.keronei.android.domain.usecases.FetchArticlesUseCase
import com.keronei.android.laptopReview.base.BaseViewModel
import com.keronei.android.laptopReview.ui.articles.state.ArticlesState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticlesViewModel(
    private val fetchArticlesUseCase: FetchArticlesUseCase,
    private val handler: SavedStateHandle
) : BaseViewModel() {

    private var fetchAllArticlesJob: Job? = null

    private val articlesList = MutableStateFlow<ArticlesState>(ArticlesState.Empty)

    val availableArticles: StateFlow<ArticlesState> = articlesList

    var selectedArticle: Article? = null
        get() {
            return field ?: handler["selectedArticle"]
        }
        set(value) {
            field = value
            handler["selectedArticle"] = value
        }

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        // val result = exception.stackTrace

        exception.printStackTrace()
    }

    init {
        getArticles()
    }

    fun getArticles() {
        fetchAllArticlesJob = launchCoroutine {
            fetchArticlesUseCase.invoke(Unit).collect { receivedArticles ->
                articlesList.emit(ArticlesState.Data(receivedArticles))
            }
        }
    }
}