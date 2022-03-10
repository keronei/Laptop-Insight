package com.keronei.android.laptopReview.extensions

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.context.GlobalContext

class Extensions {
    @KoinInternalApi
    val globalContext : Context
        get() = GlobalContext.get().scopeRegistry.rootScope.androidContext()
}