package com.example.classifiedapp.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import rx.subjects.PublishSubject

abstract class BaseListAdapter<VDB, M> :
    RecyclerView.Adapter<BaseListAdapter<VDB, M>.ViewHolder>() {

     var items = ArrayList<M>()
    val itemClickSubject: PublishSubject<M> = PublishSubject.create<M>()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.executePendingBindings()
    }

    override fun getItemCount(): Int = items.size

    internal fun ViewGroup.inflate(layoutRes: Int) =
        LayoutInflater.from(context).inflate(layoutRes, this, false)

    fun updateItems(itemList: ArrayList<M>) {
        items = itemList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

}