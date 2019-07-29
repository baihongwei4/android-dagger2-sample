package com.hongwei.android_dagger2_sample.injection.components

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.hongwei.android_dagger2_sample.MainActivity
import com.hongwei.android_dagger2_sample.injection.annotations.ActivityContext
import com.hongwei.android_dagger2_sample.injection.annotations.PerScreen
import com.hongwei.android_dagger2_sample.injection.modules.ActivityModule
import dagger.Component

@PerScreen
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent : Singletons {

    fun provideAppCompatActivity(): AppCompatActivity

    @ActivityContext
    fun provideActivityContext(): Context

    fun inject(mainActivity: MainActivity)
}