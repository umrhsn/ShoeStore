package com.umrhsn.shoestore

import android.app.Application
import timber.log.Timber

class ShoeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}