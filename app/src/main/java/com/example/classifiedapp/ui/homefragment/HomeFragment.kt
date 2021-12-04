package com.example.classifiedapp.ui.homefragment

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.classifiedapp.R
import com.example.classifiedapp.base.BaseFragment
import com.example.classifiedapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initiateView(view)
        super.onViewCreated(view, savedInstanceState)
    }



    override fun getLayout(): Int = R.layout.fragment_home

    override fun initiateView(view: View): FragmentHomeBinding = DataBindingUtil.bind(view)!!

}
