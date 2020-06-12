package com.android.flickrapp

import android.app.Activity
import android.app.Application
import com.android.flickrapp.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class FlickrApplication : Application(), HasActivityInjector {

    public companion object {
        lateinit var INSTANCE: FlickrApplication
    }

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}