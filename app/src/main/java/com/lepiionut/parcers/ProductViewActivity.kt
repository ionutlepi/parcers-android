package com.lepiionut.parcers

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.lepiionut.parcers.adapters.ListAdapter
import com.lepiionut.parcers.realm.models.Product
import com.lepiionut.parcers.realm.models.ProductSource
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import io.realm.Realm
import kotlinx.android.synthetic.main.product_view.*
import javax.inject.Inject

/**
 * Created by oneal on 9/7/2017.
 */
class ProductViewActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var realm: Observable<Realm>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_view)
        setTitle(R.string.product_sources)
        realm.subscribe({
            val products = it.where(ProductSource::class.java).findAll()
            sourceList.layoutManager = LinearLayoutManager(this@ProductViewActivity, LinearLayoutManager.VERTICAL, false)
            sourceList.adapter = ListAdapter(products, this@ProductViewActivity)
        })
    }

}