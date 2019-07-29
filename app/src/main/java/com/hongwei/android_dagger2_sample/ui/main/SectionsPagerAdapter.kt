package com.hongwei.android_dagger2_sample.ui.main

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hongwei.android_dagger2_sample.R
import com.hongwei.android_dagger2_sample.data.datasource.AppData
import com.hongwei.android_dagger2_sample.ui.Tags
import javax.inject.Inject

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    // Singleton test
    @Inject
    lateinit var appData: AppData

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Singleton test
        try {
            Log.i(Tags.TAG_SINGLETON, "appData in SectionsPagerAdapter.getCount(): $appData")
        } catch (e: UninitializedPropertyAccessException) {
            Log.i(Tags.TAG_SINGLETON, "Exception: ${e.localizedMessage} is caught!")
        }

        // Show 2 total pages.
        return 2
    }
}