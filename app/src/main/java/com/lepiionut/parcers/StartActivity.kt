package com.lepiionut.parcers

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.lepiionut.parcers.adapters.ListAdapter
import com.lepiionut.parcers.realm.models.Product
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_start.*
import javax.inject.Inject

class StartActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var realm: Observable<Realm>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        realm.subscribe {
            val products = it.where(Product::class.java).findAll()
            list.layoutManager = LinearLayoutManager(this@StartActivity, LinearLayoutManager.VERTICAL, false)
            list.adapter = ListAdapter(products, this@StartActivity)
        }
    }

    companion object {
        @JvmStatic
        val TAG = StartActivity::class.java.simpleName
    }
}
