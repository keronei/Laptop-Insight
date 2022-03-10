package com.keronei.android.mapper

import com.keronei.android.domain.models.Article
import com.keronei.android.local.entities.ArticleEntity
import kotlin.time.Duration.Companion.milliseconds

fun Article.toEntity() : ArticleEntity {
    return ArticleEntity(id, title, link, description, banner, guid, publicationDate.time)
}