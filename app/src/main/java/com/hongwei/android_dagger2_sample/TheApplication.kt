package com.hongwei.android_dagger2_sample

import android.app.Application
import com.hongwei.android_dagger2_sample.injection.components.ApplicationComponent
import com.hongwei.android_dagger2_sample.injection.components.DaggerApplicationComponent
import com.hongwei.android_dagger2_sample.injection.modules.ApplicationModule
import javax.inject.Inject

class TheApplication : Application() {
    @Inject
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    fun inject() {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build().inject(this)
    }
}