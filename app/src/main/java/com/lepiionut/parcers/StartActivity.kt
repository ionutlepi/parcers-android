package com.lepiionut.parcers

import android.app.Activity
import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.SupportActivity
import android.util.Log
import com.lepiionut.parcers.realm.models.Product

import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmConfiguration

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

    }

    companion object {
        @JvmStatic
        val TAG = StartActivity::class.java.simpleName
    }
}
