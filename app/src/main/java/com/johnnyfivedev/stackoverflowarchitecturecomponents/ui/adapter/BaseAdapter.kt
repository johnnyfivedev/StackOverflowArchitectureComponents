package com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.adapter

import android.support.v7.widget.RecyclerView
import java.util.*


abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder>() : RecyclerView.Adapter<VH>() {

    var items: List<T> = Collections.emptyList()

    override fun getItemCount(): Int {
        return items.size
    }

    fun swapItems(newItems: List<T>) {
        items = newItems
        this.notifyDataSetChanged()
    }
}
