package com.lepiionut.parcers.products

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.lepiionut.parcers.R
import com.lepiionut.parcers.adapters.ListAdapter
import com.lepiionut.parcers.realm.models.ProductPrice
import com.lepiionut.parcers.realm.models.ProductSource
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import io.realm.Realm
import kotlinx.android.synthetic.main.product_view.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


/**
 * Created by oneal on 9/7/2017.
 */
class ProductViewActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var realm: Observable<Realm>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_view)
        setTitle(R.string.product_sources)
        realm.subscribe({
            val sources = it.where(ProductSource::class.java).findAll()
            sourceList.layoutManager = LinearLayoutManager(this@ProductViewActivity, LinearLayoutManager.VERTICAL, false)
            sourceList.adapter = ListAdapter(sources, this@ProductViewActivity)

            val groups = it.where(ProductPrice::class.java).findAll()
                    .groupBy { it.source?.name }
            val lineSets = groups.map({ group ->
                val prices = group.value.map {
                    Entry(it.syncDate.time.toFloat(), it.value.toFloat())
                }
                val set =  LineDataSet(prices, group.key)
                set.valueTextSize = 8f
                return@map set
            })

            chart.data = LineData(lineSets)
            chart.xAxis.valueFormatter = DateFormated()
            chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
            chart.axisRight.isEnabled = false
            chart.setTouchEnabled(true)
            chart.setDragEnabled(true)
            chart.setScaleEnabled(true)
            chart.setPinchZoom(true)
        })
    }

    inner class DateFormated : IAxisValueFormatter {
        override fun getFormattedValue(value: Float, axis: AxisBase?): String {
            val date = Date(value.toLong())
            val simpleDateFormat = SimpleDateFormat("dd/MM")
            return simpleDateFormat.format(date)
        }

    }

}