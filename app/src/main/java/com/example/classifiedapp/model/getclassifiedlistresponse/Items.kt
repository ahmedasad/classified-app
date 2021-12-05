package com.example.classifiedapp.model.getclassifiedlistresponse

import android.os.Parcel
import android.os.Parcelable

data class Items(val price:String,val name:String,val image_urls:List<String>,val image_urls_thumbnails:List<String>):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createStringArrayList() as List<String>,
        parcel.createStringArrayList() as List<String>
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(price)
        parcel.writeString(name)
        parcel.writeStringList(image_urls)
        parcel.writeStringList(image_urls_thumbnails)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Items> {
        override fun createFromParcel(parcel: Parcel): Items {
            return Items(parcel)
        }

        override fun newArray(size: Int): Array<Items?> {
            return arrayOfNulls(size)
        }
    }

}
