package com.keronei.android.data.helpers

import java.text.SimpleDateFormat
import java.util.*

fun parseDate(textDate: String): Date {
    val dateFormatter = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.getDefault())
    return dateFormatter.parse(textDate)
}