package com.android.flickrapp.di

import com.android.flickrapp.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}