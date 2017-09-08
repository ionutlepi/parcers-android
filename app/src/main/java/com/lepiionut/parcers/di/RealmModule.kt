package com.lepiionut.parcers.di


import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.realm.*
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by ionut.lepadatescu on 25/08/2017.
 */
@Module
class RealmModule {

    @Provides
    @Singleton
    fun provideRealm(@Named("realmURL") url: String, @Named("realmURI") uri: String, sync: SyncCredentials): Observable<Realm> {
        val bus = BehaviorSubject.create<Realm>()
        SyncUser.loginAsync(sync, url, object : SyncUser.Callback {
            override fun onSuccess(syncUser: SyncUser?) {
                syncUser?.let {
                    val config = SyncConfiguration
                            .Builder(syncUser, uri)
                            .build()
                    bus.onNext(Realm.getInstance(config))
                }
            }

            override fun onError(error: ObjectServerError?) {
                bus.onError(error)
            }

        })
        return bus
    }
}