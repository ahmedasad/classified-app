package com.example.classifiedapp.ui.homefragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.classifiedapp.data.repositories.ClassifiedRepository

class HomeViewModel(private val repo:ClassifiedRepository, val app:Application) : AndroidViewModel(app) {
    val getItems = repo.getList()
}