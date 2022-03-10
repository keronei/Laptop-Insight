package com.keronei.android.mapper

import com.keronei.android.domain.models.Article
import com.keronei.android.local.entities.ArticleEntity
import java.util.*

fun ArticleEntity.toLocal() : Article {
    return Article(articleId, title, link, description, banner, guid, Date(publicationDate))
}