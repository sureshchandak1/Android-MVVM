package com.qs.mvvm.structures

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.qs.mvvm.structures.utils.helpers.ExceptionHelper
import com.qs.mvvm.structures.utils.helpers.LogHelper

class AppController : MultiDexApplication() {

    companion object {
        @get:Synchronized
        lateinit var instance: AppController private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
        LogHelper.setLog(!BuildConfig.IS_PROD || BuildConfig.DEBUG)
        ExceptionHelper.setException(!BuildConfig.IS_PROD || BuildConfig.DEBUG)
    }
}