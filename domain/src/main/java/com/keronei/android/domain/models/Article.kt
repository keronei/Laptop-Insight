package com.keronei.android.domain.models

import java.util.*

data class Article(
    val id : Int = 0,
    val title: String,
    val link: String,
    val description: String,
    val banner: String,
    val guid: String,
    val publicationDate: Date
)