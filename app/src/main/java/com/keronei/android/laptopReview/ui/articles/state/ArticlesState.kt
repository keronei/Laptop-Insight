package com.keronei.android.laptopReview.ui.articles.state

import com.keronei.android.domain.models.Article

sealed class ArticlesState {
    object Loading : ArticlesState()
    data class Data(val articles: List<Article>) : ArticlesState()
    object Empty : ArticlesState()
}
