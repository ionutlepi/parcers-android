package com.lepiionut.parcers

import android.app.Application
import android.util.Log

import com.lepiionut.parcers.realm.models.Product
import io.realm.*




/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */

class ParcersApplication: Application() {
//    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
////        val appComponent: AppComponent
//        val appComponent = DaggerAppComponent.builder().application(this).build()
//        appComponent.inject(this)
//        return appComponent
//    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this@ParcersApplication)
        val credentials = SyncCredentials.usernamePassword("oneaionut@yahoo.com","12345678ASD")
        val authURL = "http://10.100.1.62:9080"

        val user = SyncUser.loginAsync(credentials, authURL,object: SyncUser.Callback {
            override fun onSuccess(user: SyncUser?) {
                val config = SyncConfiguration
                        .Builder(user,"realm://10.100.1.62:9080/~/prod-sync")
                        .waitForInitialRemoteData()
                        .build()
                Realm.getInstanceAsync(config, object : Realm.Callback() {
                    override fun onSuccess(realm: Realm?) {
                        val results = realm?.where(Product::class.java)?.findAllAsync()
                        results?.addChangeListener( RealmChangeListener {
                            Log.d(StartActivity.TAG,"changed")
                        })
                    }

                })
            }

            override fun onError(error: ObjectServerError?) {
                Log.d(TAG, "not user logged int")
            }

        })

    }

    companion object {
        @JvmStatic
        val TAG = ParcersApplication::class.java.simpleName
    }
}
