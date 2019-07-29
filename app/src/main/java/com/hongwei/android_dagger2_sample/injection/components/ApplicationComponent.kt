package com.hongwei.android_dagger2_sample.injection.components

import com.hongwei.android_dagger2_sample.TheApplication
import com.hongwei.android_dagger2_sample.injection.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent: Singletons {

    fun inject(application: TheApplication)
}