package com.lepiionut.parcers.realm.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Required

/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */
open class Product: RealmObject() {

    @Required
    var name: String? = null

    var sources: RealmList<ProductSource>? = null
}