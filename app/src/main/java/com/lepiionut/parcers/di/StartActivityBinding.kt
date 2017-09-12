package com.lepiionut.parcers.di

import com.lepiionut.parcers.products.ProductViewActivity
import com.lepiionut.parcers.products.StartActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector


/**
 * Created by ionut.lepadatescu on 25/08/2017.
 */
@Module(includes = arrayOf(AndroidInjectionModule::class))
abstract class StartActivityBinding {

    @ContributesAndroidInjector
    internal abstract fun startActivityInjector(): StartActivity

    @ContributesAndroidInjector
    internal abstract fun productViewActivity(): ProductViewActivity
}