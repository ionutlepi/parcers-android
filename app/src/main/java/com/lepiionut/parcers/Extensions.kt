@file:JvmName("ExtensionsUtils")

package com.lepiionut.parcers

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */
fun <T> Observable<T>.schedulers(): Observable<T> {
    return compose({ upstream ->
        upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    })
}

fun <T> Flowable<T>.schedulers(): Flowable<T> {
    return compose({ upstream ->
        upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    })
}