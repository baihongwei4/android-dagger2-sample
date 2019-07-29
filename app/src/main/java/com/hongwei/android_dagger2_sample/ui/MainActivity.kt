package com.hongwei.android_dagger2_sample.ui

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.hongwei.android_dagger2_sample.R
import com.hongwei.android_dagger2_sample.TheApplication
import com.hongwei.android_dagger2_sample.data.datasource.AppData
import com.hongwei.android_dagger2_sample.injection.components.ActivityComponent
import com.hongwei.android_dagger2_sample.injection.components.DaggerActivityComponent
import com.hongwei.android_dagger2_sample.injection.modules.ActivityModule
import com.hongwei.android_dagger2_sample.ui.Tags.TAG_SINGLETON
import com.hongwei.android_dagger2_sample.ui.main.SectionsPagerAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var activityComponent: ActivityComponent

    // Singleton test
    @Inject
    lateinit var appData: AppData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        // Singleton test
        Log.i(TAG_SINGLETON, "appData in MainActivity.onCreate(): $appData")
    }

    fun inject() {
        DaggerActivityComponent.builder()
                .applicationComponent((applicationContext as TheApplication).applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
    }
}