package com.keronei.android.laptopReview.di

import com.keronei.android.laptopReview.ui.articles.ArticlesViewModel
import com.keronei.android.laptopReview.ui.favourite.FavouriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ArticlesViewModel(fetchArticlesUseCase = get(), get())
    }

    viewModel {
        FavouriteViewModel(get())
    }
}