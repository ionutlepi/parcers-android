package com.lepiionut.parcers.realm.models

import com.lepiionut.parcers.SimpleListItem
import com.lepiionut.parcers.products.ProductSourceForm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */

open  class  ProductSource: RealmObject(), SimpleListItem {
    override fun getDisplayName(): String {
        return name.orEmpty()
    }

    override fun getNextScreenActivity(): Class<*> {
        return ProductSourceForm::class.java
    }


    @PrimaryKey
    var id: Int = 0

    @Required
    var name: String? = null

    @Required
    var url: String? = null

    var product: Product? = null


}
