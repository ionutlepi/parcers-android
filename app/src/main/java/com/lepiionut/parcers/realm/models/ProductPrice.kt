package com.lepiionut.parcers.realm.models

import io.realm.RealmObject
import io.realm.annotations.Required
import java.util.*

/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */

open class ProductPrice: RealmObject() {


    var value: Double = 0.0

    @Required
    lateinit var syncDate: Date

    var source: ProductSource? = null
}