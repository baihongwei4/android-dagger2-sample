package com.hongwei.android_dagger2_sample

import android.app.Application
import android.util.Log
import com.hongwei.android_dagger2_sample.data.datasource.AppData
import com.hongwei.android_dagger2_sample.injection.components.ApplicationComponent
import com.hongwei.android_dagger2_sample.injection.components.DaggerApplicationComponent
import com.hongwei.android_dagger2_sample.injection.modules.ApplicationModule
import com.hongwei.android_dagger2_sample.ui.Tags
import javax.inject.Inject

class TheApplication : Application() {
    @Inject
    lateinit var applicationComponent: ApplicationComponent

    // Singleton test
    @Inject
    lateinit var appData: AppData

    override fun onCreate() {
        super.onCreate()
        inject()

        // Singleton test
        Log.i(Tags.TAG_SINGLETON, "appData in TheApplication.onCreate(): $appData")
    }

    fun inject() {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build().inject(this)
    }
}