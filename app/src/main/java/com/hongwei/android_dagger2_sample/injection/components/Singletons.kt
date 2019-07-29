package com.hongwei.android_dagger2_sample.injection.components

import android.content.Context
import com.hongwei.android_dagger2_sample.injection.annotations.AppContext

interface Singletons {
    @AppContext
    fun provideContext(): Context
}