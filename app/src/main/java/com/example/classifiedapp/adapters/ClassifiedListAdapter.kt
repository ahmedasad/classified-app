package com.example.classifiedapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classifiedapp.databinding.RowClassifiedBinding
import com.example.classifiedapp.model.getclassifiedlistresponse.Items
import com.example.classifiedapp.utils.Helper
import com.jakewharton.rxbinding.view.RxView
import rx.subjects.PublishSubject

class ClassifiedListAdapter(val context: Context) :
    RecyclerView.Adapter<ClassifiedListAdapter.ViewHolder>() {

    var items = ArrayList<Items>()
    val itemClickSubject: PublishSubject<Items> = PublishSubject.create()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RowClassifiedBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }


    fun updateItems(itemList: ArrayList<Items>) {
        items = itemList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        RxView.clicks(holder.itemView).subscribe {
            val model = items[position]
            itemClickSubject.onNext(model)
        }
        Helper.loadImg(holder.img,items[position].image_urls_thumbnails[0])
        holder.titleText.text = items[position].name
        Helper.setPrice(holder.priceText,items[position].price)
    }

    inner class ViewHolder(itemView: RowClassifiedBinding) : RecyclerView.ViewHolder(itemView.root) {
        val img = itemView.img
        val titleText = itemView.titleText
        val priceText = itemView.priceText

    }

}