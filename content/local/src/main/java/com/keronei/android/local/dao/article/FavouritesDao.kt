package com.keronei.android.local.dao.article

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.keronei.android.local.entities.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertFavouriteArticle(article: ArticleEntity)

    @Query("SELECT * FROM articles")
    suspend fun getFavouriteArticles(): List<ArticleEntity>

    @Query("DELETE FROM articles WHERE articleId = :articleIdentifier")
    suspend fun removeFromFavourite(articleIdentifier: Int) : Int
}