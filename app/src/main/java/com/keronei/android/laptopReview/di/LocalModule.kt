package com.keronei.android.laptopReview.di

import android.content.Context
import androidx.room.Room
import com.keronei.android.local.constants.Constants.DATABASE_NAME
import com.keronei.android.local.dao.article.ArticleDao
import com.keronei.android.local.dao.article.FavouritesDao
import com.keronei.android.local.database.ArticleDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        databaseInstanceProvider(androidContext())
    }

    single { provideArticleDatabase(database = get()) }

    single { provideFavouriteArticleDatabase(database = get()) }

}

internal fun databaseInstanceProvider(context: Context): ArticleDatabase {
    return Room.databaseBuilder(
        context,
        ArticleDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()
}

internal fun provideArticleDatabase(database: ArticleDatabase): ArticleDao = database.articleDao

internal fun provideFavouriteArticleDatabase(database: ArticleDatabase): FavouritesDao =
    database.favouritesDao