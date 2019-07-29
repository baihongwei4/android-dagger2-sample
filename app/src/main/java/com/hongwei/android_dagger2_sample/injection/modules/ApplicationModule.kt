package com.hongwei.android_dagger2_sample.injection.modules

import android.app.Application
import android.content.Context
import com.hongwei.android_dagger2_sample.injection.annotations.AppContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    @AppContext
    fun provideContext(): Context = application
}