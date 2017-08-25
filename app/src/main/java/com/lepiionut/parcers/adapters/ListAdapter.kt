package com.lepiionut.parcers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lepiionut.parcers.R
import com.lepiionut.parcers.realm.models.Product
import kotlinx.android.synthetic.main.simple_list_item.view.*

/**
 * Created by ionut.lepadatescu on 21/08/2017.
 */
class ListAdapter(val items: List<Product>?, val context: Context): RecyclerView.Adapter<ListAdapter.ListItemHolder>() {

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        if(items?.get(position) != null) {
            holder.bind(product = items[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListItemHolder {
        return ListItemHolder(LayoutInflater.from(context).inflate(R.layout.simple_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    class ListItemHolder(val rootView: View): RecyclerView.ViewHolder(rootView) {
        fun bind(product: Product) {
            rootView.itemTitle.text = product.name
        }
    }
}