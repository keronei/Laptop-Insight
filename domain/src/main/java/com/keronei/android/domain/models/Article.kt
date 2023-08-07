package com.keronei.android.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Article(
    val id: Int = 0,
    val title: String,
    val link: String,
    val description: String,
    val banner: String,
    val guid: String,
    val publicationDate: Date
) : Parcelable
