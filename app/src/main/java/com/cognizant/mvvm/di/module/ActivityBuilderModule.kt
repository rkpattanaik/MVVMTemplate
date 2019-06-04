package com.cognizant.mvvm.di.module

import com.cognizant.mvvm.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun bindHomeActivity(): HomeActivity
}