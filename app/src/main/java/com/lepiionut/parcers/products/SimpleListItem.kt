package com.lepiionut.parcers.products



/**
 *
 * Created by ionut.lepadatescu on 25/08/2017.
 */
interface SimpleListItem {
    fun getDisplayName(): String

    /**
     * Maybe this should not pollute the Realm Models ?
     */
    fun getNextScreenActivity(): Class<*>
}