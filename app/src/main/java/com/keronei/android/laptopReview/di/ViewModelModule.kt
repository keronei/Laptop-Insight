package com.keronei.android.laptopReview.di

import com.keronei.android.laptopReview.ui.articles.ArticlesViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        ArticlesViewModel(fetchArticlesUseCase = get())
    }
}