package com.keronei.android.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keronei.android.local.dao.article.ArticleDao
import com.keronei.android.local.dao.article.FavouritesDao
import com.keronei.android.local.entities.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class ArticleDatabase : RoomDatabase() {

    abstract val articleDao: ArticleDao

    abstract val favouritesDao: FavouritesDao


}