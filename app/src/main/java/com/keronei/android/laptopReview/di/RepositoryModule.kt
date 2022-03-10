package com.keronei.android.laptopReview.di

import com.keronei.android.data.repository.RemoteArticlesDataSource
import com.keronei.android.domain.repositories.ArticlesRepository
import com.keronei.android.domain.repositories.FavouriteArticlesRepository
import com.keronei.android.repository.ArticlesRepositoryImpl
import com.keronei.android.repository.FavouriteArticlesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<FavouriteArticlesRepository> {
        FavouriteArticlesRepositoryImpl(favouritesDao = get())
    }

    single<ArticlesRepository> {
        ArticlesRepositoryImpl(articleDao = get(), remoteArticlesDataSource = get())
    }

    single { RemoteArticlesDataSource(ktorClient = get()) }
}