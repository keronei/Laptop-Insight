package com.keronei.android.laptopReview.app

import android.app.Application
import com.keronei.android.laptopReview.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class LRApplication : Application() {

    override fun onCreate() {
        super.onCreate()

       // if (DEBUG) {
            Timber.plant(Timber.DebugTree())
       // }

        prepareDI()

    }

    private fun prepareDI() {
        startKoin {

            androidContext(this@LRApplication)

            modules(
                networkModule, databaseModule, repositoryModule, useCaseModule, viewModelModule
            )
        }
    }
}