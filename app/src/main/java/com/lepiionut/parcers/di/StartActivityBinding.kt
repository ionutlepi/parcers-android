package com.lepiionut.parcers.di

import com.lepiionut.parcers.StartActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector


/**
 * Created by ionut.lepadatescu on 25/08/2017.
 */
@Module(includes = arrayOf(AndroidInjectionModule::class))
abstract class StartActivityBinding {

    @ContributesAndroidInjector(modules = arrayOf(RealmModule::class))
    internal abstract fun startActivityInjector(): StartActivity
}