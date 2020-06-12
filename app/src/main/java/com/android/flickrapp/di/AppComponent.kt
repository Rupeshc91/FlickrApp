package com.android.flickrapp.di

import dagger.Component

@Component(modules = [ActivityBuilderModule::class, NetworkModule::class, DataModule::class, ViewModelModule::class])
interface AppComponent {
}