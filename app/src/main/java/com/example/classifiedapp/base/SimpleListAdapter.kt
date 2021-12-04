package com.example.classifiedapp.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.jakewharton.rxbinding.view.RxView

class SimpleListAdapter<VDB,M>(@LayoutRes private val resId:Int):BaseListAdapter<VDB,M>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewDataBinding = DataBindingUtil.bind<ViewDataBinding>(parent.inflate(resId))
        val holder = ViewHolder(viewDataBinding)
        RxView.clicks(viewDataBinding!!.root).subscribe {
            val model = items[holder.adapterPosition]
            itemClickSubject.onNext(model)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        binding?.setVariable(BR.model,items[position])
        super.onBindViewHolder(holder, position)
    }

}