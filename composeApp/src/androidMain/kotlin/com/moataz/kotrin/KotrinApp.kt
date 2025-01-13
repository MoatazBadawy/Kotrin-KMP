package com.moataz.kotrin

import android.app.Application
import com.moataz.kotrin.app.di.initKoin

class KotrinApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}