package com.keronei.android.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity (
    @PrimaryKey(autoGenerate = true)
    val articleId : Int,
    val title : String,
    val link : String,
    val description : String,
    val banner : String,
    val guid : String,
    val publicationDate : Long
)