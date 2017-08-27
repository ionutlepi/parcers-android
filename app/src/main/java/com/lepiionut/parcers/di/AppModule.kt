package com.lepiionut.parcers.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by ionut.lepadatescu on 25/08/2017.
 */
@Module
abstract class AppModule {

    @Binds abstract fun bindContext(application: Application): Context
}