package com.example.classifiedapp.ui.homefragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.classifiedapp.data.repositories.classifiedRepository

class HomeViewModel(private val repo:classifiedRepository, val app:Application) : AndroidViewModel(app) {
    val getItems = repo.getList()
}