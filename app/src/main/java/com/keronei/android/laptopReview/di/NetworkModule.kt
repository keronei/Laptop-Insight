package com.keronei.android.laptopReview.di

import android.util.Xml
//import com.keronei.android.data.BuildConfig
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.logging.*
import org.koin.dsl.module
import timber.log.Timber

val networkModule = module {
    single {
        provideHttpClient()
    }

    single {
        Xml.newPullParser()
    }

}

internal fun provideHttpClient(): HttpClient {
    return HttpClient(CIO) {
       // if (BuildConfig.DEBUG) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Timber.d("kTor : $message")
                    }
                }
                level = LogLevel.HEADERS
        //    }
        }
    }
}