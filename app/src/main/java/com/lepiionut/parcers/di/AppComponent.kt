package com.lepiionut.parcers.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton


/**
 * Created by ionut.lepadatescu on 25/08/2017.
 */
@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, ConfigModule::class, AppModule::class, StartActivityBinding::class))
interface AppComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}