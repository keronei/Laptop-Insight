package com.keronei.android.laptopReview.di

import com.keronei.android.domain.usecases.FetchArticlesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        FetchArticlesUseCase(articlesRepository = get())
    }
}
