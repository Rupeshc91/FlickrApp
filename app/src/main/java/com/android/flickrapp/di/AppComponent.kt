package com.android.flickrapp.di

import android.app.Application
import com.android.flickrapp.FlickrApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ActivityBuilderModule::class, NetworkModule::class, DataModule::class,
        ViewModelModule::class, AndroidInjectionModule::class, FragmentBuilderModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(application: FlickrApplication)
}