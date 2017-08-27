package com.lepiionut.parcers.realm.models

import com.lepiionut.parcers.SimpleListItem
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Required

/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */
open class Product : RealmObject(), SimpleListItem {

    override fun getDisplayName(): String {
        return name ?: ""
    }

    @Required
    var name: String? = null

    var sources: RealmList<ProductSource>? = null
}