package com.lepiionut.parcers.realm.models

import io.realm.RealmObject
import io.realm.annotations.Required
import java.util.*

/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */

open class ProductPrice: RealmObject() {

    @Required var value: Double? = null

    @Required var syncDate: Date? = null

    var source: ProductSource? = null
}