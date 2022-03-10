package com.keronei.android.local.dao.article

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.keronei.android.local.entities.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertArticle(articlesList: List<ArticleEntity>) : List<Long>

    @Query("SELECT * FROM articles")
    fun getArticles(): Flow<List<ArticleEntity>>

    @Query("DELETE FROM articles WHERE articleId NOT IN (SELECT articleId FROM articles ORDER BY articleId LIMIT 30)")
    suspend fun cleanUpArticles() //https://stackoverflow.com/questions/46193356/limit-the-number-of-rows-in-a-room-database
}