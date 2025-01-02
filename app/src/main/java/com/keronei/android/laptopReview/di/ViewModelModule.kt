package com.keronei.android.laptopReview.di

import com.keronei.android.laptopReview.ui.articles.ArticlesViewModel
import com.keronei.android.laptopReview.ui.favourite.FavouriteViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        ArticlesViewModel(fetchArticlesUseCase = get(), get())
        FavouriteViewModel(get())
    }
}