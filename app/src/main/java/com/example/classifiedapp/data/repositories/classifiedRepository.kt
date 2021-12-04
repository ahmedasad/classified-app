package com.example.classifiedapp.data.repositories

import com.example.classifiedapp.base.BaseRepo
import com.example.classifiedapp.data.network.services.ClassifiedServices

class classifiedRepository(private val services: ClassifiedServices): BaseRepo() {
    fun getList() = getNetworkResult{ services.getClassifiedList() }
}