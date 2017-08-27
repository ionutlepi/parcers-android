package com.lepiionut.parcers.di

import dagger.Module
import dagger.Provides
import io.realm.SyncCredentials
import javax.inject.Named

/**
 * Created by ionut.lepadatescu on 25/08/2017.
 */
@Module
class ConfigModule {

    @Provides
    @Named("realmDB")
    fun realmDB(): String {
        return "prod-sync"
    }

    @Provides
    @Named("realmHost")
    fun realmHost(): String {
        return "192.168.0.104"
    }

    @Provides
    @Named("realmPort")
    fun realmPort(): String {
        return "9080"
    }

    @Provides
    @Named("realmURI")
    fun provideRealmUri(@Named("realmHost") host: String, @Named("realmPort") port: String, @Named("realmDB") db: String): String {
        return "realm://$host:$port/~/$db"
    }

    @Provides
    @Named("realmURL")
    fun provideRealmUrl(@Named("realmHost") host: String, @Named("realmPort") port: String): String {
        return "http://$host:$port"
    }

    @Provides
    fun providesSyncCredentials(): SyncCredentials {
        return SyncCredentials.usernamePassword("oneaionut@yahoo.com", "12345678ASD")
    }


}
