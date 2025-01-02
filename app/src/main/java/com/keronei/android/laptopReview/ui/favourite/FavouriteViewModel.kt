package com.keronei.android.laptopReview.ui.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keronei.android.domain.models.Article
import com.keronei.android.domain.repositories.FavouriteArticlesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavouriteViewModel(private val favouriteArticlesRepository: FavouriteArticlesRepository) :
    ViewModel() {

    private val _articles: MutableStateFlow<List<Article>> = MutableStateFlow(emptyList())

    val articles = _articles.asStateFlow()
    fun toggleFavourite(article: Article) {
        viewModelScope.launch {
            if (_articles.value.any { art -> article.id == art.id }) {
                favouriteArticlesRepository.removeFavouriteArticles(article)
            } else {
                favouriteArticlesRepository.addFavouriteArticles(article)
            }
        }
    }

    init {
        viewModelScope.launch {
            favouriteArticlesRepository.fetchFavouriteArticles()
                .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
                .collect { _articles.value = it }
        }
    }
}