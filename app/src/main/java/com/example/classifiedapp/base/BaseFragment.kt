package com.example.classifiedapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment<out VDB>:Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments!=null){
            handleArguments(arguments!!)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayout(),container,false)
        initiateView(view)
        return view
    }

    open fun handleArguments(arguments: Bundle){}
    abstract fun getLayout():Int
    abstract fun initiateView(view: View):VDB
}