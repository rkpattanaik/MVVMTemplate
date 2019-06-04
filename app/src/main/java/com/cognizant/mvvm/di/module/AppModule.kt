package com.cognizant.mvvm.di.module

import com.cognizant.mvvm.data.source.PostsRepository
import com.cognizant.mvvm.data.source.PostsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class,
    NetworkModule::class
])
abstract class AppModule {

    @Binds
    @Singleton
    internal abstract fun providePostsRepository(postsRepository: PostsRepositoryImpl): PostsRepository
}