package com.keronei.android.local.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "articles",
    indices = [Index(name = "title_enforcement", value = ["title", "description"], unique = true)]
)
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val articleId: Int,
    val title: String,
    val link: String,
    val description: String,
    val banner: String,
    val guid: String,
    val publicationDate: Long
)