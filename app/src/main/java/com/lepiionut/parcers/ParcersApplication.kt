package com.lepiionut.parcers

import com.lepiionut.parcers.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.realm.Realm


/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */

open class ParcersApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }


    override fun onCreate() {
        super.onCreate()
        Realm.init(this.applicationContext)

    }

    companion object {
        @JvmStatic
        val TAG = ParcersApplication::class.java.simpleName
    }
}
