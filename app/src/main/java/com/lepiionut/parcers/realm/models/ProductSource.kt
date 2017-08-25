package com.lepiionut.parcers.realm.models

import io.realm.RealmObject
import io.realm.annotations.Required

/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */

open  class  ProductSource: RealmObject() {


    @Required var name: String? = null

    @Required
    var url: String? = null
}
